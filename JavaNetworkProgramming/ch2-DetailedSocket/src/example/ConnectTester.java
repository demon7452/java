package example;

import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * 连接抛出异常测试
 * @author demon7452
 *@version 2014-9-3
 */
public class ConnectTester
{
	/**
	 * 尝试连接connect，抛出异常！
	 * @param host 服务器域名
	 * @param port 目的端口
	 */
	public void connect(String host,int port)
	{
		SocketAddress remoteAddress = new InetSocketAddress(host,port); //获得host服务器监听端口为port的的地址；
		Socket socket = null;
		String result = "";
		try
		{
			long begin = System.currentTimeMillis();  //开始时间
			socket = new Socket();  //创建一个socket对象,抛出异常。
			socket.connect(remoteAddress, 5000);   //尝试连接，连接时间为一秒
			long end = System.currentTimeMillis();  //结束时间
			result = "连接成功，时间：";
			result += ((end - begin)/1000)+"s " + ((end-begin)%1000)+"ms";
		}
		catch(BindException e)
		{
			result = "Loal address and port can't be binded";
		}
		catch (UnknownHostException e) {
			// TODO: handle exception
			result = "Unknown host";
		}
		catch (ConnectException e) {
			// TODO: handle exception
			result = "Connection refused";
		}
		catch (SocketTimeoutException e) {
			// TODO: handle exception
			result  = "Time out";
		}
		catch (IOException  e) {
			// TODO: handle exception
			result = "failure";
		}
		finally
		{
			try 
			{
				if(socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("the host is "+host+" the port is  "+port);
			System.out.println(remoteAddress + ":" +result);
		}
	}

	/**
	 * main method
	 * @param args
	 */
	public static void main(String [] args)
	{
//		   new ConnectTester().connect("www.baidu.com", 80);
//		   new ConnectTester().connect("www.google.com", 80);
//		   new ConnectTester().connect("www.github.com", 80);
		   
		   SocketAddress test = new InetSocketAddress("www.google.com",80);
		   System.out.println(test);
		String host = "localhost";
//		int[] portArray  = {80,135,445,1025,1026,1027,1028,1051,1103,1104,139,33473,33449};
		int port = 135;
//		for(int i = 0;i< portArray.length;i++)
//		{
//			port = portArray[i];
			if(args.length > 1)
			{
				host = args[0];
				port = Integer.parseInt(args[1]);
			}
//			new ConnectTester().connect(host, port);
//		}
	}
}