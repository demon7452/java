import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * This program implements a multithreaded server that listens to port 8188 and echoes back
 * all client input
 * @author demon7452
 * @version 2014-9-19 
 */
public class ThreadEchoServer
{
		public static void main(String[] args)
		{
			try 
			{
				ServerSocket serverSocket = new ServerSocket(8188);
				int number = 1;
				while(true)
				{
					Socket socket = serverSocket.accept();
					
					Runnable runnable = new ThreadedEchoHandler(socket,number);
					Thread thread = new Thread(runnable);
					thread.start();
				    System.out.println("客户端链接"+number+"：" + socket.getRemoteSocketAddress());
				    number++;
				}
			} 
			catch (Exception e) 
			{
				// TODO: handle exception
			}
		}
}

/**
 * this class handles the client input for one server socket connection
 * @author Administrator
 *
 */
class ThreadedEchoHandler implements Runnable
{
	private Socket socket;
	private int number;
	
	/**
	 * Constructs a handler
	 * @param socket the incoming socket
	 * @param number the counter for the handlers(used in prompts)
	 */
	public ThreadedEchoHandler(Socket socket, int number)
	{
		this.socket = socket;
		this.number = number;
	}
	public void run()
	{
		try 
		{
			try
			{
				InputStream inStream = socket.getInputStream();
				OutputStream outStream = socket.getOutputStream();
				
				Scanner in = new Scanner(inStream);//获取客户端输入数据
				PrintWriter out = new PrintWriter(outStream,true /* autoFlush */ );//自动清空并发送？
				
				out.println("hello! print 'bye' to exit!");//成功连接进行问候
				boolean done = false;
				while(!done && in.hasNextLine())
				{
					String lineString = in.nextLine();
					System.out.println("client"+number+": "+lineString);
					out.println("received: "+lineString);
					if(lineString.trim().equals("bye"))
						done = true;
				}
				System.out.println("断开连接！");
				out.println("close link");
			} 
			finally
			{
				if(socket != null)
					socket.close();
			}
		}
		catch (IOException e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}