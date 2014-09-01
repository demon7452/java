package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * server 
 * @author demon7452
 * @version 2014-9-1
 */
public class EchoServer
{
	private int port = 8000;
	private ServerSocket serverSocket;
	
	/**
	 * construction method
	 * @throws IOException
	 */
	public EchoServer()throws IOException
	{
		serverSocket = new ServerSocket(port);
		System.out.println("服务器启动");
	}
	
//	public static void main(String[] args)throws IOException
//	{
//		System.out.println("sb");
//		EchoServer echoServer = new EchoServer();
//		echoServer.service();
//	}
	/**
	 * for the msg to add echo
	 * @param msg
	 * @return echo:msg
	 */
	public String echo(String msg)
	{
		return "echo:"+msg;
	}
	
	/**
	 * 获得输出流
	 * @param socket
	 * @return output 
	 * @throws IOException
	 */
	private PrintWriter getWriter(Socket socket)throws IOException
	{
		OutputStream socketOut = socket.getOutputStream();
		return new PrintWriter(socketOut);
	}
	
	/**
	 * 获得输入流
	 * @param socket
	 * @return	input
	 * @throws IOException
	 */
	private BufferedReader getReader(Socket socket)throws IOException
	{
		InputStream socketInput = socket.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(socketInput);
		return new BufferedReader(inputStreamReader);
	}
	
	/**
	 * method service() to listen in client conneciton
	 * 监听客户连接，打印输入流，输出输出流！
	 * 最后断开客户连接！
	 */
	public void service()
	{
		while(true)
		{
			Socket socket = null;
			try
			{
				socket = serverSocket.accept();   //等待客户连接
				System.out.println("New connection accepted "+socket.getInetAddress()+":"+socket.getPort());
				
				BufferedReader br = getReader(socket); //用br保存输入流
				PrintWriter pw = getWriter(socket);    //用pw保存输出流
				
				String msg = null;
				while((msg = br.readLine()) != null)   //读取输入流中的一行字符串，判断是否为空
				{
					System.out.println(msg);
					
					pw.println(echo(msg));     //向输出流中写入echo + 输入的字符串
					
					if(msg.equals("bye"))    //如果客户发送消息为bye ，就结束通信，条出while循环
					{
						break;
					}
				}  //#while
			}
			catch(IOException e)
			{
				e.printStackTrace();    //抛出异常，throws IOException
			}
			finally
			{
				try
				{
					if(socket != null)
					{
						socket.close();    //如果客户连接不为空，关闭socket;
						System.out.println("断开客户连接！");
					}
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * main method!
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args)throws IOException
	{
		
//		EchoServer echoServer = new EchoServer();
//		echoServer.service();
		new EchoServer().service();
	}
		
}