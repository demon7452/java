package section5SelectionScalability;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
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

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	//----------------------------------------------------
	/**
	 * A very simple thread pool class. The pool size is set at construction
	 * time and remains fixed. Threads are cycled through a FIFO idle queue.线程循环通过一个FIFO空闲队列
	 */
	private class ThreadPool
	{
		java.util.List idle = new LinkedList();
		public ThreadPool(int poolSize)
		{
			// TODO Auto-generated constructor stub
			//Fill up the pool with worker threads
			for(int i = 0; i < poolSize; i++)
			{
				
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
				catch (Exception e)
				{
					// TODO: handle exception
				}
			}
		}
	}
}



















