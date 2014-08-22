package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * establish a blocking server
 * use multiple threads to handle multiple connections
 * 建立阻塞服务器,使用多个线程处理多个连接
 * @author demon7452
 * @version 2014-8-21
 */
public class BlockingServer
{
	private int port = 8000;
	private ServerSocketChannel serverSocketChannel = null;
	private ExecutorService executorService;     //线程池
	/**
	 * 线程池中工作线程的数目.
	 */
	private static final int POOL_MULTIPLE = 4;
	
	/**
	 * Construction method BlockingServer()
	 * 构造方法
	 * @throws IOException
	 */
	public BlockingServer() throws IOException
	{
		//创建一个线程池
		//获取当前系统的CPU数目  int cpuNums = Runtime.getRuntime().availableProcessors();
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_MULTIPLE);
		
		//创建一个ServerSocketChannel对象
		serverSocketChannel = ServerSocketChannel.open();
		
		//使得在同一个主机上关闭了服务器程序,紧接着再启动该服务器程序时,可以顺利绑定相同的端口
		serverSocketChannel.socket().setReuseAddress(true);
		
		//把服务器进程与一个本地端口绑定
		serverSocketChannel.socket().bind(new InetSocketAddress(port));
		System.out.println("服务器启动");
	}
	
	/**
	 * method service() 处理客户连接
	 * @throws IOException
	 */
	public void service()
	{
		while(true)
		{
			SocketChannel socketChannel = null;
			try 
			{
				socketChannel = serverSocketChannel.accept();
				executorService.execute(new Handler(socketChannel)) ;//处理客户连接	
			} 
			catch (IOException e) 
			{
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * main method
	 * 调用service()方法
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		new BlockingServer().service();
	}
}
/**
 * 处理客户连接
 * @version 2014-8-21
 * @author demon7452
 *
 */
class Handler implements Runnable
{
	private SocketChannel socketChannel;
	
	/**
	 * 构造方法,传递SocketChannel 对象
	 * @param socketChannel
	 */
	public Handler (SocketChannel socketChannel)
	{
		this.socketChannel = socketChannel;
	}
	
	public void run()
	{
		handle(socketChannel);
	}
	
	/**
	 * 
	 * @param socketChannel
	 * {@link Handler#getWriter(Socket)}
	 * {@link Handler#getWriter(Socket)}
	 * {@link Handler#echo(String)}
	 */
	public void handle(SocketChannel socketChannel)
	{
		try 
		{
			Socket socket = socketChannel.socket(); //获得与socketChannel关联的Socket对象
			System.out.println("接收到客户连接,来自:"+socket.getInetAddress()+":"+socket.getPort());
			
			BufferedReader br = getReader(socket);
			PrintWriter pw = getWriter(socket);
			
			String msg = null;
//			System.out.println(br.readLine());
			while((msg=br.readLine())!=null)//br.readLine(),读取数据
			{
				System.out.println(msg);
				pw.println(echo(msg));//打印数据
				if(msg.equals("bye"))
					break;
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(socketChannel != null)
					socketChannel.close();//关闭数据连接
			}
			catch (IOException e) 
			{
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param socket
	 * @return 写出
	 * @throws IOException
	 */
	private  PrintWriter getWriter(Socket socket) throws IOException 
	{
		OutputStream socketOut = socket.getOutputStream();
		return new PrintWriter(socketOut,true);
	}
	/**
	 * 
	 * @param socket
	 * @return 输入的字符
	 * @throws IOException
	 */
	private BufferedReader getReader (Socket socket) throws IOException
	{
		InputStream socketIn = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(socketIn));
	}
	/**
	 * 
	 * @param msg
	 * @return echo+msg
	 */
	public String echo(String msg)
	{
		return "echo:"+msg;
	}
}