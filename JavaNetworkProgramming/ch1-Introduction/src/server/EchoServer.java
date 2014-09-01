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
		System.out.println("����������");
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
	 * ��������
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
	 * ���������
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
	 * �����ͻ����ӣ���ӡ������������������
	 * ���Ͽ��ͻ����ӣ�
	 */
	public void service()
	{
		while(true)
		{
			Socket socket = null;
			try
			{
				socket = serverSocket.accept();   //�ȴ��ͻ�����
				System.out.println("New connection accepted "+socket.getInetAddress()+":"+socket.getPort());
				
				BufferedReader br = getReader(socket); //��br����������
				PrintWriter pw = getWriter(socket);    //��pw���������
				
				String msg = null;
				while((msg = br.readLine()) != null)   //��ȡ�������е�һ���ַ������ж��Ƿ�Ϊ��
				{
					System.out.println(msg);
					
					pw.println(echo(msg));     //���������д��echo + ������ַ���
					
					if(msg.equals("bye"))    //����ͻ�������ϢΪbye ���ͽ���ͨ�ţ�����whileѭ��
					{
						break;
					}
				}  //#while
			}
			catch(IOException e)
			{
				e.printStackTrace();    //�׳��쳣��throws IOException
			}
			finally
			{
				try
				{
					if(socket != null)
					{
						socket.close();    //����ͻ����Ӳ�Ϊ�գ��ر�socket;
						System.out.println("�Ͽ��ͻ����ӣ�");
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