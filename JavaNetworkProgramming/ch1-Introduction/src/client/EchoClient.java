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
		socket = new Socket(host,port);  //�󶨶˿ں�host 
	}
	
   public void cnnect()throws IOException
   {
	   bReader = getReader(socket);
	  System.out.println(bReader.readLine());
   }
	
	/**
	 * ����д�������
	 * @param socket
	 * @return PrintWriter,�����
	 * @throws IOException
	 */
	public PrintWriter getWriter(Socket socket)throws IOException
	{
		OutputStream outputStream = socket.getOutputStream();
		return new PrintWriter(outputStream,true); //����true��ʾÿдһ�У�PrintWriter������Զ������������д��Ŀ�ĵء�
	}
	
	/**
	 * ����������
	 * @param socket
	 * @return ������
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
			BufferedReader br = getReader(socket); //������
			PrintWriter pw = getWriter(socket);  //�����
			
			BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));  //�ͻ�����������
			
			String msg = null;
			while((msg = localReader.readLine()) != null)    //msg���ڿͻ�����������
			{
				System.out.println("�ͻ�����:"+msg );
				//����д��client�������OutputStrem,��Ӧ��server��������InputStream
				pw.println(msg); //������д��������������Զ������д��Ŀ�ĵأ�д���������OutputStream�ͻ�����������������ݣ�
				
//				System.out.println(br.readLine());//��InputStream�ж�ȡ����
				
				if(msg.equals("bye"))
				{
					System.out.println(br.readLine()); //��������Ͽ�����ʾ�����������ĶϿ���Ϣ
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