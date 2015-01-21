package section5SelectionScalability;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;

import section3UseSelector.SelectSockets;

/**
 * Specialization(特殊化) of the SelectSockets class which uses a thread pool to service
 * channels. The thread pool is an ad-hoc(特设的) implementation(实现) quicky lashed(捆绑) togther
 * in a few hours fo demonstration(演示) purposes. It's definitely not production quality.
 * @author lixiong
 * @date 2014-11-14
 */
public class SelectSocketsThreadPool extends SelectSockets
{
	private static final int MAX_THREADS = 5;
	private ThreadPool pool = new ThreadPool(MAX_THREADS);

	// ---------------------------------------------------------------
	public static void main(String[] args)throws Exception
	{
		// TODO Auto-generated method stub
		new SelectSocketsThreadPool().go(args);//调用父类SelectSockets.go()方法
	}
	
	//---------------------------------------------------------
	/**
	 * Sample data handler method for a channel with data ready to read.
	 * 样品数据处理的方法 
	 * This method is invoked (调用)from the go() method in the parent class.
	 * This handler delegates to a worker thread in a thread pool to service the channel,then returns immediately.
	 * 
	 * @param key
	 * 			A SelectionKey object representing a channel determined
	 */
	//----------------------------------------------------
	/**
	 * A very simple thread pool class. The pool size is set at construction
	 * time and remains fixed. Threads are cycled through a FIFO idle queue.线程循环通过一个FIFO空闲队列
	 */
	private class ThreadPool
	{
		java.util.List idle = new LinkedList();
		ThreadPool(int poolSize)
		{
			// TODO Auto-generated constructor stub
			//Fill up the pool with worker threads
			for(int i = 0; i < poolSize; i++)
			{
				WorkerThread thread = new WorkerThread(this);//??
				
				//Set thread name for debugging. Start it.
				thread.setName("Worker" + (i+1) );
				thread.start();
				
				idle.add(thread);
			}
		}
		
		/**
		 * Find an idle worker thread, if any. Could return null.
		 */
		WorkerThread getWorker()
		{
			WorkerThread worker = null;
			synchronized (idle)
			{
				if(idle.size() > 0)
				{
					worker = (WorkerThread) idle.remove(0);
				}
			}
			return worker;
		}
		
		/**
		 * Called by the worker thread to return itself to the idle pool.
		 */
		void returnWorker(WorkerThread worker)
		{
			synchronized (idle)
			{
				idle.add(worker);
			}
		}
	}
	
	/**
	 * A worker thread class which can drain channels and echo-back the input.
	 * 一个工作的线程类可以清空通道和回复输入
	 * Each instance is constructed with a reference to the owning thread pool object.
	 * 每个实例的构建都是参照拥有的线程池对象。
	 * When started, the thread loops forever waiting to be awakened to service the channel 
	 * associated with a SelectionKey object.
	 * 启动后，这个线程循环等待被唤醒服务于与SelectionKey对象关联的通道
	 *  The worker is tasked by calling its serviceChannel()
	 * method stores the key reference in the thread object then calls notify() to wake it up. 
	 * 这个工作线程目的在于调用serviceChannel方法存储key,然后调用notify()方法唤醒……
	 * When the channel has been drained, the worker thread returns itself to its parent pool.
	 * 当通道被清空后，这个工作线程回到线程池。
	 */
	private class WorkerThread extends Thread
	{
		private ByteBuffer buffer = ByteBuffer.allocate(1024);
		private ThreadPool pool;
		private SelectionKey key;
		
		public WorkerThread(ThreadPool pool)
		{
			// TODO Auto-generated constructor stub
			this.pool = pool;
		}
		// Loop forever waiting for work to do
		public synchronized void run()
		{
			System.out.println(this.getName() + " is ready");
			while(true)
			{
				try
				{
					//sleep and release object lock睡眠和释放对象锁
					this.wait();
				}
				catch (InterruptedException e)
				{
					// TODO: handle exception
					e.printStackTrace();
					//Clear interrupt status
					this.interrupted();
				}
				if(key == null)
				{
					continue;// just in case
				}
				System.out.println(this.getName() + " has been awakened");
				try
				{
					drainChannel(key);//调用drainChannel方法,读取出通道中的数据？
				}
				catch (Exception e)
				{
					// TODO: handle exception
					System.out.println("Caught '" + e + "' closing channel!");
					
					//Close channel and nudge(推动) selector
					try
					{
						key.channel().close();
					}
					catch (IOException ex)
					{
						// TODO: handle exception
						ex.printStackTrace();
					}
					
					key.selector().wakeup();//??
				}
				
				key = null; //??
				
				//Done. Ready for more.Return to pool
				this.pool.returnWorker(this);
			}
		}
		
		/**
		 * Called to initiate a unit of work by this worker thread on the provided SelectionKey object.
		 * 通过一个提供的SelectionKey对象呼叫启动一个工作单元
		 * This method is synchronized, as is the run() method,so only one key can be serviced at a given time.
		 * 这个方法是同步的，一次只能服务一个key
		 * Before waking the worker thread,and before returning to the main selection loop,this key's interest 
		 * set is updated to remove OP_READ.This will cause the selector to ignore read-readiness for this 
		 * channel while the worker thread is servicing it.
		 * @param key
		 */
		synchronized void serviceChannnel(SelectionKey key)
		{
			this.key = key;
			key.interestOps(key.interestOps() & (~SelectionKey.OP_READ));//remove OP_READ
			this.notify();//Awaken the thread
		}
		
		/**
		 * The actual code which drains the channel associated with the give key.
		 * This method assumes the key has been modified prior to invocation to turn off selection
		 * interest in OP_READ. When this method completes it re-enables OP_READ and calls wakeup()
		 * on the selector so the selector will resume watching this channel.
		 * @param key
		 * @throws Exception
		 */
		void drainChannel(SelectionKey key)throws Exception
		{
			SocketChannel channel = (SocketChannel) key.channel();
			int count;
			buffer.clear();// Empty buffer
			
			//Loop while data is available; channel is nonblocking
			while((count = channel.read(buffer)) > 0)
			{
				buffer.flip();//make buffer readale
				//Send the data; may not go all at once
				while(buffer.hasRemaining())
				{
					channel.write(buffer);
				}
				//WARING:the above loop,is evil.
				//See comments in superclass.
				buffer.clear();// Empth buffer
			}
			if(count < 0)
			{
				// Close channel on EOF; invalidates the key
				channel.close();
				return;
			}
			
			//Reusme interest in OP_READ
			key.interestOps(key.interestOps() | SelectionKey.OP_READ);
			
			//Cycle the selector so this key is active again
			key.selector().wakeup();
		}
	}//#end WorkThread
}