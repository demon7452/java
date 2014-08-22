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
 * ��������������,ʹ�ö���̴߳���������
 * @author demon7452
 * @version 2014-8-21
 */
public class BlockingServer
{
	private int port = 8000;
	private ServerSocketChannel serverSocketChannel = null;
	private ExecutorService executorService;     //�̳߳�
	/**
	 * �̳߳��й����̵߳���Ŀ.
	 */
	private static final int POOL_MULTIPLE = 4;
	
	/**
	 * Construction method BlockingServer()
	 * ���췽��
	 * @throws IOException
	 */
	public BlockingServer() throws IOException
	{
		//����һ���̳߳�
		//��ȡ��ǰϵͳ��CPU��Ŀ  int cpuNums = Runtime.getRuntime().availableProcessors();
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_MULTIPLE);
		
		//����һ��ServerSocketChannel����
		serverSocketChannel = ServerSocketChannel.open();
		
		//ʹ����ͬһ�������Ϲر��˷���������,�������������÷���������ʱ,����˳������ͬ�Ķ˿�
		serverSocketChannel.socket().setReuseAddress(true);
		
		//�ѷ�����������һ�����ض˿ڰ�
		serverSocketChannel.socket().bind(new InetSocketAddress(port));
		System.out.println("����������");
	}
	
	/**
	 * method service() ����ͻ�����
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
				executorService.execute(new Handler(socketChannel)) ;//����ͻ�����	
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
	 * ����service()����
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		new BlockingServer().service();
	}
}
/**
 * ����ͻ�����
 * @version 2014-8-21
 * @author demon7452
 *
 */
class Handler implements Runnable
{
	private SocketChannel socketChannel;
	
	/**
	 * ���췽��,����SocketChannel ����
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
			Socket socket = socketChannel.socket(); //�����socketChannel������Socket����
			System.out.println("���յ��ͻ�����,����:"+socket.getInetAddress()+":"+socket.getPort());
			
			BufferedReader br = getReader(socket);
			PrintWriter pw = getWriter(socket);
			
			String msg = null;

			
			while((msg=br.readLine())!=null)//br.readLine(),��ȡ����
			{
				System.out.println(msg);
				pw.println(echo(msg));//��ӡ����
				if(msg.equals("bye"))
					break;
			}
			
//			ʹ��SocketChannel��readLine()������ȡ�ַ���!
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
					socketChannel.close();//�ر���������
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
	 * @return д��
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
	 * @return ������ַ�
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
	
	public String readLine(SocketChannel socketChannel)throws IOException
	{
//		������ж���������,�ٶ�һ���ַ�����Ӧ���ֽ����еĳ���С��1024
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
//		���һ�ζ���������,һ��ֻ��һ���ֽ�
		ByteBuffer  tempBuffer = ByteBuffer.allocate(1);
		boolean isLine = false; //��ʾ�Ƿ������һ���ַ���
		boolean isEnd = false;  //��ʾ�Ƿ񵽴�����������ĩβ
		String data = null;
		
		while (!isLine && !isEnd)
		{
			tempBuffer.clear();  //��ջ�����
			
			//������ģʽ��,ֻ�еȵ�����1���ֽڻ��߶���������ĩβ�ŷ���;�ڷ�����ģʽ��,���ܷ���0
			int n = socketChannel.read(tempBuffer);      //n=-1��ʾ����������ĩβ,n=0��ʾ����Ϊ��.
			
			if(n == -1)
			{
				isEnd = true;
				break;//���������������ĩβ,�ͷ���null,����while
			}
			if(n == 0)
			{
				continue;
			}
			tempBuffer.flip();   //�Ѽ�����Ϊλ��,�ٰ�λ����Ϊ0
			buffer.put(tempBuffer);        //��tempBuffer�е����ݸ��Ƶ�buffer��
			buffer.flip();//�Ѽ�����Ϊλ��,�ٰ�λ����Ϊ0
			
			Charset charset = Charset.forName("GBK");
			CharBuffer charBuffer = charset.decode(buffer); //����,���ֽ�ת��GBK�ַ�
			data = charBuffer.toString();
			
			if(data.indexOf("\r\n") != -1)
			{
				isLine = true; //������һ���ַ���
				data = data.substring(0,data.indexOf("\r\n"));
				break;
			}
			
			buffer.position(buffer.limit());        //��λ����Ϊ����,Ϊ�´ζ�ȡ������׼��
			buffer.limit(buffer.capacity());        //�Ѽ�����Ϊ����,Ϊ�´ζ�������׼��
		}//#while
		//���������һ���ַ���,�ͷ��������ַ���,�������н�����"\r\n"
		//���������������ĩβ,�ͷ���null
		return data;
	}
}