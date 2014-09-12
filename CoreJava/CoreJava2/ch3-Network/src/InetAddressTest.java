import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * this program demonstrates the InetAddress class.Supply a host name as command line
 * argument,or run without command line arguments to see the address of the local host.
 * @author demon7452
 * @version 2014-9-12
 */
public class InetAddressTest
{
	public static void main(String[] args)
	{
		try 
		{
			if(args.length > 0)
			{
				String host = args[0];
				InetAddress[] addresses = InetAddress.getAllByName(host);
				for(InetAddress address : addresses)
					System.out.println(address);
			}
			else
			{
				InetAddress localAddr = InetAddress.getLocalHost();//获得本地地址
				System.out.println(localAddr);
				System.out.println(localAddr.getAddress());
				System.out.println(localAddr.getHostAddress());
				System.out.println(localAddr.getHostName());
				
				byte[] byteAddr = localAddr.getAddress();
				
				Charset charset = Charset.forName("GBK");
				ByteBuffer buffer = ByteBuffer.wrap(byteAddr);//将一个字节数组转换成一个字节缓冲区
				CharBuffer cBuffer = charset.decode(buffer);//decode返回一个CharBuffer
				String string = cBuffer.toString();
				System.out.println(string);
			}
			
			//获得google ip 地址
			InetAddress googleAddress = InetAddress.getByName("www.google.com");//获得单个IP
			System.out.println(googleAddress);
			InetAddress[] googleAllAddress = InetAddress.getAllByName("www.google.com");//获得多个的IP
			for(InetAddress address : googleAllAddress)
				System.out.println(address);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}