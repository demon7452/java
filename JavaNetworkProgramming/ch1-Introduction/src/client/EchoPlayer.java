package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

/**
 * java network programming
 * chapter 1,Introduction 
 * 1-1,example,EchoPlayer;
 * @author demon7452
 * @version 2014-8-27
 */
public class EchoPlayer
{
	public String echo(String msg)
	{
		return "echo:"+msg;
	}
	
	public void talk()throws IOException
	{
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		String msg = null;
		
		while((msg=bReader.readLine()) != null)
		{
			System.out.println(echo(msg));
			if(msg.equals("bye"))
			{
				System.out.println("end,bye!");
				break;
			}
		}
	}
	public static void main(String[] args)throws IOException
	{
		new EchoPlayer().talk();
	}
}