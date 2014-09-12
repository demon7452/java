package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
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

//			System.out.println("显示没!");
			while((msg=br.readLine())!=null)//br.readLine(),读取数据
			{
				System.out.println(br.readLine());
//				System.out.println("显示没!");//为什么不会显示?
				
				pw.println(echo(msg));//在客户端打印数据
				if(msg.equals("bye"))
				{
					System.out.println("断开与客户端的连接!");
					break;
				}
			}
			
//			使用SocketChannel的readLine()方法读取字符串!
//			msg = readLine(socketChannel);
//			System.out.println(msg);
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
	
	/**
	 * SocketChannel 的方法 readLine()
	 * @param socketChannel
	 * @return 数据data
	 * @throws IOException
	 */
	public String readLine(SocketChannel socketChannel)throws IOException
	{
//		存放所有读到的数据,假定一行字符串对应的字节序列的长度小于1024
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
//		存放一次读到的数据,一次只读一个字节
		ByteBuffer  tempBuffer = ByteBuffer.allocate(1);
		boolean isLine = false; //表示是否读到了一行字符串
		boolean isEnd = false;  //表示是否到达了输入流的末尾
		String data = null;
		
		while (!isLine && !isEnd)
		{
			tempBuffer.clear();  //清空缓冲区
			
			//在阻塞模式下,只有等到读了1个字节或者读到输入流末尾才返回;在非阻塞模式下,可能返回0
			int n = socketChannel.read(tempBuffer);      //n=-1表示读到输入流末尾,n=0表示读入为空.
			
			if(n == -1)
			{
				isEnd = true;
				break;//如果到达输入流的末尾,就返回null,跳出while
			}
			if(n == 0)
			{
				continue;
			}
			tempBuffer.flip();   //把极限设为位置,再把位置设为0
			buffer.put(tempBuffer);        //把tempBuffer中的数据复制到buffer中
			buffer.flip();//把极限设为位置,再把位置设为0
			
			Charset charset = Charset.forName("GBK");
			CharBuffer charBuffer = charset.decode(buffer); //解码,将字节转成GBK字符
			data = charBuffer.toString();
			
			if(data.indexOf("\r\n") != -1)
			{
				isLine = true; //读到了一行字符串
				data = data.substring(0,data.indexOf("\r\n"));
				break;
			}
			
			buffer.position(buffer.limit());        //把位置设为极限,为下次读取数据做准备
			buffer.limit(buffer.capacity());        //把极限设为容量,为下次读数据作准备
		}//#while
		//如果读入了一行字符串,就返回这行字符串,不包括行结束符"\r\n"
		//如果到达输入流的末尾,就返回null
		return data;
	}
}