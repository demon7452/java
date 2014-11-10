package section3UseSelector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Simple echo-back server which listens for incoming stream connections(串流式连接) and
 * echoes back whatever it reads. A single Selector object is used to listen to 
 * the server socket (to accept new connections) and all the active socket channels. 
 * @author lixiong
 * @date 2014-11-6
 */
public class SelectSockets
{
	public static int PORT_NUMBER = 1234;//端口号
	public static void main(String[] args)throws Exception
	{
		// TODO Auto-generated method stub
		new SelectSockets().go(args);
	}
	
	public void go (String[] args) throws Exception
	{
		int port = PORT_NUMBER;
		
		if(args.length > 0)
		{
			//Override default listen port
			port = Integer.parseInt(args[0]);
		}
		
		System.out.println("Listening on port " + port);
		
		//Allocate an unbound server socket channel 分配一个未绑定的服务器套接字通道
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		//Get the associated ServerSocket to bind it with
		ServerSocket serverSocket = serverSocketChannel.socket();
		
		//Set the port the server channel will listen to  服务器绑定端口 
		serverSocket.bind(new InetSocketAddress(port));
		
		//Set nonblocking mode for the listening socket 设定通道为非阻塞
		serverSocketChannel.configureBlocking(false);
		
		//Create a new Selector for use below
		Selector selector = Selector.open();
		
		//Register the ServerSocketChannel with the Selector 通道绑定选择器，注册连接事件
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		while (true)
		{
			//This may block for a long time. Upon returning, the 
			//selected set contains keys of the ready channels.
			int n = selector.select(); //??已连接就绪的事件数目
			
			if (n == 0)
			{
				continue; //nothing to do,跳出这一次while循环，继续等待
			}
			
			// Get an iterator over the set of selected keys  ??使用迭代器遍历一选择的键
			Iterator<?> it = selector.selectedKeys().iterator();
			
			//Look at each key in the selected set
			while (it.hasNext())
			{
				SelectionKey key = (SelectionKey) it.next();
				
				//Is a new connection comming in?
				if (key.isAcceptable())
				{
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					SocketChannel channel = server.accept();
					registerChannel(selector, channel, SelectionKey.OP_READ);//??
					sayHello(channel);
				}
				
				//Is there data to read on this channel?
				if (key.isReadable())
				{
					readDataFromSocket(key);
				}
				
				// Remove key from selected set; it's been handled
				it.remove();
			}
		}
	}
	
	// ------------------------------------------------------------
	/**
	 * Register the given channel with the given selector for the given
	 * operations of interest
	 */
	protected void registerChannel(Selector selector, SelectableChannel channel, int ops)throws Exception
	{
		if (channel == null)
		{
			return;  //could happen
		}
		
		// Set the new channel nonblocking
		channel.configureBlocking(false);
		
		// Register it with the selector
		channel.register(selector, ops);
	}
	
	// --------------------------------------------------
	//Use the same byte buffer for all channels. A single thread is 
	//servicing all the channels, so no danger of concurrent同时发生的 accesss.
	private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
	
	// --------------------------------------------------
	/**
	 * Spew a greeting to the incoming client connection
	 * @param channel
	 * 			The newly connected SocketChannel to say hello to.
	 * @throws Exception
	 */
	private void sayHello (SocketChannel channel) throws Exception
	{
		buffer.clear();
		buffer.put("Hi there!\r\n".getBytes());
		buffer.flip();
		
		channel.write(buffer);//从缓冲区中向通道里写数据
	}
	
	// ---------------------------------------------------
	/**
	 * Sample data handler method for a channel with data ready to read
	 * @param key
	 * 			A SelectionKey object associated with a channel determined by the selector
	 * 			to be ready for reading. If the channel returns  an EOF condition, it is closed
	 * 			here, which automatically invalidates the associated key. The selsector will then 
	 * 			de-register the channel on the next select call.
	 * @throws Exception
	 */
	protected void readDataFromSocket(SelectionKey key) throws Exception
	{
		SocketChannel socketChannel = (SocketChannel) key.channel();
		int count;
		
		buffer.clear(); // Empty buffer
		
		// Loop while data is available; channel is nonblocking
		while((count = socketChannel.read(buffer)) > 0)
		{
			buffer.put("  data back!\r\n".getBytes());
			buffer.flip(); //Make buffer readable
			
			// Send the data; don't assume it goes all at one
			while (buffer.hasRemaining())
			{
				socketChannel.write(buffer);  //??向通道写数据？将数据回传！
			}
			
			//WARNING:the above loop is evil.Because it's writing back to the same
			//nonblocking channel it read the data from,this code can potentially
			//spin in a busy loop. In real life you'd do something more useful than this.
			
			buffer.clear(); //empty buffer.
			
			if(count < 0)
			{
				// close channel on EOF, invalidates使无效 the key
				socketChannel.close();
			}
		}
	}
}
