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
 * non blocking server ������������
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
		selector = Selector.open(); //����һ��Selector����
		serverSocketChannel = ServerSocketChannel.open(); //����һ��ServerSocketChannel����
		serverSocketChannel.socket().setReuseAddress(true);//ʹ����ͬһ�������Ϲر��˷���������,�������������÷��������,����˳���󶨵���ͬ�Ķ˿�
		serverSocketChannel.configureBlocking(false);//ʹserverSocketChannel�����ڷ�����ģʽ
		serverSocketChannel.socket().bind(new InetSocketAddress(port));//�ѷ�����������һ�����ض˿ڰ�
		System.out.println("����������!");
	}
	
	public void service() throws IOException
	{
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (selector.select() > 0)         //��һ��whileѭ��
		{
			Set readKeys = selector.selectedKeys();//���Selector��selected-keys����
			Iterator  it = readKeys.iterator();
			while(it.hasNext())             //�ڶ���whileѭ��
			{
				SelectionKey key = null;
				try									//����SelectionKey
				{
					key = (SelectionKey)it.next();		//ȡ��һ��SelectionKey
					it.remove();   //��SelectionKey��selector��selectedKeys()������ɾ��
					if(key.isAcceptable())//����������Ӿ����¼�{}
					{
						ServerSocketChannel ssc = (ServerSocketChannel)key.channel();//�����SelectionKey������ServerSocketChannel
						SocketChannel socketChannel = (SocketChannel)ssc.accept();  //�����ͻ����ӵ�SocketChannel
						System.out.println("���յ��ͻ�����,����:"+socketChannel.socket().getInetAddress()+":"+socketChannel.socket().getPort());
						socketChannel.configureBlocking(false);//��Ϊ������ģʽ
						ByteBuffer buffer = ByteBuffer.allocate(1024); //����һ�����ڴ���û������������ݵĻ�����
						//SocketChannel��Selectorע��������¼���д�����¼�
						socketChannel.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE, buffer);   //������һ��buffer����
						
					}
					if(key.isReadable())//����������¼�{}
					{
						receive(key);
					}
					if(key.isWritable())//����д�����¼�
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
							//ʹ�����SelectionKeyʧЧ
							//���Selector���ټ�������SelectionKey����Ȥ���¼�
							key.cancel();
							key.channel().close();//�ر������SelectionKey������SocketChannel
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
		System.out.println("���ݿɶ�!");
		ByteBuffer buffer = (ByteBuffer)key.attachment();//�����SelectionKey�����ĸ���
		SocketChannel socketChannel = (SocketChannel)key.channel();//�����SelectionKey������SocketChannel
		//����һ��ByteBuffer,���ڴ�Ŷ���������
		ByteBuffer readBuff = ByteBuffer.allocate(32);
		socketChannel.read(readBuff);
		readBuff.flip();
		
		buffer.limit(buffer.capacity());//��buffer�ļ�����Ϊ����
		//��readBuffer�е����ݿ�����buffer��,�ٶ�buffer�������㹻��,������ֻ���������쳣
		buffer.put(readBuff);
	}
	
	public void send(SelectionKey key)throws IOException
	{
		System.out.println("��д");
		ByteBuffer buffer = (ByteBuffer)key.attachment();//�����SelectionKey������ByteBuffer
		SocketChannel socketChannel = (SocketChannel)key.channel();//�����SelectionKey������SocketChannel
		buffer.flip();    //�Ѽ�����Ϊλ��,��λ����Ϊ0
		
		//����GBK����,��buffer�е��ֽ�ת��Ϊ�ַ���
		String data = decode(buffer);
		//�����û�ж���һ������,�ͷ���
		if(data.indexOf("\r\n") == -1)
			return; 
		//��ȡһ������
		String outputData = data.substring(0,data.indexOf("\n")+1);
		System.out.print(outputData);
		
		//��������ַ�������GBK����,ת��Ϊ�ֽ�,��������outputBuffer��
		ByteBuffer outputBuffer = encode("echo"+outputData);
		//���outputBuffer�е������ֽ�
		while(outputBuffer.hasRemaining())
			socketChannel.write(outputBuffer);
		
		//��outputData�ַ�������GBK����,ת��Ϊ�ֽ�,��������byteBuffer��
		ByteBuffer temp	= encode(outputData);
		//��buffer��λ����Ϊtemp�ļ���
		buffer.position(temp.limit());
		buffer.compact();//ɾ��buffer���Ѿ����������
		
		//����Ѿ�������ַ���"bye\r\n",��ʹSelectionKeyʧЧ,���ر�SocketChannel
		if(outputData.equals("bye\r\n"))
		{
			key.cancel();
			socketChannel.close();
			System.out.println("�ر���ͻ�������!");
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