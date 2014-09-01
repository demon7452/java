package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * EchoClient
 * @author demon7452
 * @version 2014-9-1
 */
public class EchoClient
{
	private  String host  = "localhost";
	private int port = 8000;
	private Socket socket;
	private BufferedReader bReader;
	/**
	 * construction method
	 * @throws IOException
	 */
	public EchoClient()throws IOException
	{
		socket = new Socket(host,port);  //绑定端口和host 
	}
	
   public void cnnect()throws IOException
   {
	   bReader = getReader(socket);
	  System.out.println(bReader.readLine());
   }
	
	/**
	 * 数据写入输出流
	 * @param socket
	 * @return PrintWriter,输出流
	 * @throws IOException
	 */
	public PrintWriter getWriter(Socket socket)throws IOException
	{
		OutputStream outputStream = socket.getOutputStream();
		return new PrintWriter(outputStream,true); //参数true表示每写一行，PrintWriter缓存就自动溢出，把数据写到目的地。
	}
	
	/**
	 * 返回输入流
	 * @param socket
	 * @return 输入流
	 * @throws IOException
	 */
	public BufferedReader getReader (Socket socket)throws IOException
	{
		InputStream inputStream = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(inputStream));
	}
	
	public void talk()throws IOException
	{
		try
		{
			BufferedReader br = getReader(socket); //输入流
			PrintWriter pw = getWriter(socket);  //输出流
			
			BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));  //客户端输入数据
			
			String msg = null;
			while((msg = localReader.readLine()) != null)    //msg等于客户端输入数据
			{
				System.out.println("客户输入:"+msg );
				//数据写入client的输出流OutputStrem,对应于server的输入流InputStream
				pw.println(msg); //将数据写入输出流，缓存自动溢出，写到目的地，写到输出流中OutputStream客户端向服务器发送数据！
				
//				System.out.println(br.readLine());//从InputStream中读取数据
				
				if(msg.equals("bye"))
				{
					System.out.println(br.readLine()); //与服务器断开后，显示服务器发来的断开信息
					break;
				}
			}  //#while
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
				socket.close();
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
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args)throws IOException
	{
			EchoClient client = new EchoClient();
//			client.cnnect();
			client.talk();
			
//		new EchoClient().talk();
	}

}