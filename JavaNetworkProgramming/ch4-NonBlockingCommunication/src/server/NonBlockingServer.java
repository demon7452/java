package server;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
/**
 * non blocking server 非阻塞服务器
 * @author demon7452
 * @version 2014-8-25
 */
public class NonBlockingServer
{
	private Selector selector = null;
	private ServerSocketChannel serverSocketChannel = null;
	private int port = 8000;
	private Charset charset = Charset.forName("GBK");
	
	public NonBlockingServer() throws IOException
	{
		selector = Selector.open(); //创建一个Selector对象
		serverSocketChannel = ServerSocketChannel.open(); //创建一个ServerSocketChannel对象
		serverSocketChannel.socket().setReuseAddress(true);//使得在同一个主机上关闭了服务器程序,紧接着再启动该服务程序是,可以顺利绑定到相同的端口
		serverSocketChannel.configureBlocking(false);//使serverSocketChannel工作于非阻塞模式
		serverSocketChannel.socket().bind(new InetSocketAddress(port));//把服务器进程与一个本地端口绑定
		System.out.println("服务器启动!");
		System.out.println(SelectionKey.OP_READ|SelectionKey.OP_WRITE);
		System.out.println(~SelectionKey.OP_READ);
	}
	
	public void service() throws IOException
	{
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (selector.select() > 0)         //第一层while循环
		{
			Set readKeys = selector.selectedKeys();//获得Selector的selected-keys集合
			Iterator  it = readKeys.iterator();
			while(it.hasNext())             //第二层while循环
			{
				SelectionKey key = null;
				try									//处理SelectionKey
				{
					key = (SelectionKey)it.next();		//取出一个SelectionKey
					it.remove();   //把SelectionKey从selector的selectedKeys()集合中删除
					if(key.isAcceptable())//处理接收连接就绪事件{}
					{
						ServerSocketChannel ssc = (ServerSocketChannel)key.channel();//获得与SelectionKey关联的ServerSocketChannel
						SocketChannel socketChannel = (SocketChannel)ssc.accept();  //获得与客户连接的SocketChannel
						System.out.println("接收到客户连接,来自:"+socketChannel.socket().getInetAddress()+":"+socketChannel.socket().getPort());
						socketChannel.configureBlocking(false);//设为非阻塞模式
						ByteBuffer buffer = ByteBuffer.allocate(1024); //创建一个用于存放用户发送来的数据的缓冲区
						//SocketChannel向Selector注册读就绪事件和写就绪事件
						socketChannel.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE, buffer);   //关联了一个buffer附件
						
//						key.cancel();
//						socketChannel.close();
//						System.out.println("duan kai lian jie");
					}
					if(key.isReadable())//处理读就绪事件{}
					{
						receive(key);
					}
					if(key.isWritable())//处理写就绪事件
					{
						send(key);
					}
				}
				catch (IOException e)
				{
					// TODO: handle exception
					e.printStackTrace();
					try
					{
						if(key != null)
						{
							//使得这个SelectionKey失效
							//舍得Selector不再监控者这个SelectionKey感兴趣的事件
							key.cancel();
							key.channel().close();//关闭与这个SelectionKey关联的SocketChannel
						}
					}
					catch (IOException ex)
					{
						ex.printStackTrace();
					}
				}
			}      //#while
			
		}      //#while
	}
	
	
	public void receive(SelectionKey key) throws IOException
	{
//		System.out.println("数据可读!");
		ByteBuffer buffer = (ByteBuffer)key.attachment();//获得与SelectionKey关联的附件
		SocketChannel socketChannel = (SocketChannel)key.channel();//获得与SelectionKey关联的SocketChannel
		//创建一个ByteBuffer,用于存放读到的数据
		ByteBuffer readBuff = ByteBuffer.allocate(32);
		socketChannel.read(readBuff);
		readBuff.flip();
		
		buffer.limit(buffer.capacity());//把buffer的极限设为容量
		//把readBuffer中的内容拷贝到buffer中,假定buffer的容量足够大,不会出现缓冲区溢出异常
		buffer.put(readBuff);
		System.out.println(decode(buffer));
	}
	
	public void send(SelectionKey key)throws IOException
	{
		ByteBuffer buffer = (ByteBuffer)key.attachment();//获得与SelectionKey关联的ByteBuffer
		SocketChannel socketChannel = (SocketChannel)key.channel();//获得与SelectionKey关联的SocketChannel
		buffer.flip();    //把极限设为位置,把位置设为0
		
		//按照GBK编码,把buffer中的字节转换为字符串
		String data = decode(buffer);
		//如果还没有读到一行数据,就返回
		if(data.indexOf("\r\n") == -1)
			return; 
		//截取一行数据
		String outputData = data.substring(0,data.indexOf("\n")+1);
		System.out.print(outputData);
		
		//把输出的字符串按照GBK编码,转换为字节,把它放在outputBuffer中
		ByteBuffer outputBuffer = encode("echo"+outputData);
		//输出outputBuffer中的所有字节
		while(outputBuffer.hasRemaining())
			socketChannel.write(outputBuffer);
		
		//把outputData字符串按照GBK编码,转换为字节,把它放在byteBuffer中
		ByteBuffer temp	= encode(outputData);
		//把buffer的位置设为temp的极限
		buffer.position(temp.limit());
		buffer.compact();//删除buffer中已经处理的数据
		
		//如果已经输出了字符串"bye\r\n",就使SelectionKey失效,并关闭SocketChannel
		if(outputData.equals("bye\r\n"))
		{
			key.cancel();
			socketChannel.close();
			System.out.println("关闭与客户的连接!");
		}
	}
	
	public String decode(ByteBuffer buffer)
	{
		CharBuffer charBuffer = charset.decode(buffer);
		return charBuffer.toString();
	}
	public ByteBuffer encode(String string)
	{
		return charset.encode(string);
	}
	 
	public static void main(String[] args)throws IOException
	{
		NonBlockingServer server = new NonBlockingServer();
		server.service();
		
	}
}