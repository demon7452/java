package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/**
 * blocking client,阻塞的客户端
 * @author demon7452
 * @version 2014-8-22
 */
public class BlockingClient
{
	private SocketChannel socketChannel = null;
	
	/**
	 * 构造方法
	 * @throws IOException
	 */
	public BlockingClient () throws IOException
	{
		socketChannel = SocketChannel.open();
		InetAddress iAddress = InetAddress.getLocalHost();//获取ip地址
		InetSocketAddress isa = new InetSocketAddress(iAddress,8000);//绑定端口
		socketChannel.connect(isa);     //连接服务器
		System.out.println("与服务器建立连接成功!");
	}
	/**
	 * main method 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args)throws IOException
	{
		new BlockingClient().talk();
	}
	/**
	 * 
	 * @param socket
	 * @return PrintWriter
	 * @throws IOException
	 */
	private PrintWriter getWriter(Socket socket)throws IOException
	{
		OutputStream socketOut = socket.getOutputStream();
		return new PrintWriter(socketOut,true);
	}
	/**
	 * 
	 * @param socket
	 * @return BufferedReader
	 * @throws IOException
	 */
	private BufferedReader getReader(Socket socket)throws IOException
	{
		InputStream socketIn = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(socketIn)); 	
	}
	
	/**
	 * talk method
	 * @throws IOException
	 */
	public void talk()throws IOException
	{
		try 
		{
			BufferedReader bReader = getReader(socketChannel.socket());
			PrintWriter pWriter = getWriter(socketChannel.socket());
			
			BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
			
			String msg = null;
			while((msg=localReader.readLine()) != null)
			{
				pWriter.println(msg);//在服务器端打印数据
				System.out.println(bReader.readLine());
				
				if (msg.equals("bye"))
				{
					System.out.println("与服务器端断开连接!");
					break;
				}
					
			}
		} 
		catch (IOException e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				socketChannel.close();
			} 
			catch (IOException e)
			{
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}