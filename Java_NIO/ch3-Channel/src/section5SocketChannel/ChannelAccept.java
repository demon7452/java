package section5SocketChannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Test nonblocking accept() using ServerSocketChannel.
 * Start this program,then "telnet localhost 1234" to connect to it.
 * @author lixiong
 * @date 2014-10-25
 */
public class ChannelAccept
{
	public static final String GREETING = "Hello I must be going.\r\n";
	public static void main(String[] args)throws Exception
	{
		// TODO Auto-generated method stub
		int port = 1234; //default
		//可以通过运行时 java ChannelAccept 1024 向args字符串数组传值，
		//args[0]=1024,如果没有传值则数组长度为0
		if(args.length > 0)
		{
			port = Integer.parseInt(args[0]);
		}
		
		//用包装的方法将一个字符串数组创建为缓冲区
		ByteBuffer buffer = ByteBuffer.wrap(GREETING.getBytes());
		
		//用静态的工厂方法open()创建一个ServerSocketChannel对象
		ServerSocketChannel ssc = ServerSocketChannel.open();
		
		//等价于ServerSocket ss = ssc.socket(); 返回一个ServerSocket对象
		ssc.socket().bind(new InetSocketAddress(port));
		
		ssc.configureBlocking(false);//非阻塞
		
		while(true)
		{
			System.out.println("waiting for connection");
			//网络发来连接请求，返回一个表示连接已经建立的socket对象
			SocketChannel sc = ssc.accept();
			
			if(sc == null)
			{
				//no connections, snooze a while 2000ms=2s
				Thread.sleep(2000);
			}
			else
			{
				//输出连接来的地址
				System.out.println("Incoming connection from: " + sc.socket().getRemoteSocketAddress());
				
				buffer.rewind();//倒回，position 设为0，limit不变
				System.out.println(buffer.position());
				System.out.println(buffer.limit());
				sc.write(buffer);//从缓冲区向通道中写入数据，传递到连接来的socket终端
				sc.close();
			}
		}
	}
}
