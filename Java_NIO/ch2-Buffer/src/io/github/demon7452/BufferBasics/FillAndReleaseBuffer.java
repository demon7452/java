package io.github.demon7452.BufferBasics;

import java.nio.BufferOverflowException;
import java.nio.CharBuffer;
/**
 * Buffer fill/drain example. this code uses the simplest 
 * means of filling and draining a buffer: one element at a time
 * @author demon7452
 * @version 2014-9-30
 */
public class FillAndReleaseBuffer 
{
	private static int index = 0;
	private static String[] strings = 
		{
			"A random string value","The product of an infinite number of monkeys",
			"Hey hey we're the Monkees","Opening act for the Monkees:Jimi Hendrix",
			"'Scuse me while i kiss this fly","help me help me",
			"The product of an infinite number of monkeysThe product of an infinite number of monkeys number of monkeys",
		};
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		CharBuffer buffer = CharBuffer.allocate(100);//设定缓冲池大小为100
		while(fillBuffer(buffer))
		{
			buffer.flip();//翻转，position设为0，设定limit
			drainBuffer(buffer);//输出缓冲池内容
			buffer.clear();//清空缓冲池
		}

	}
	/**
	 * 输出缓冲池内容
	 * @param buffer
	 */
	private static void drainBuffer(CharBuffer buffer)
	{
		while(buffer.hasRemaining())
		{
			System.out.print(buffer.get());
		}
		System.out.print("\n");
	}
	/**
	 * 向缓冲池填入数据
	 * @param buffer
	 * @return 填入是否成功
	 */
	private static boolean fillBuffer(CharBuffer buffer)
	{
		if(index >= strings.length)
		{
			return (false);
		}
//		String string = null;
//		for(int j = 0; j < strings.length; j++)
//		{
//			string += strings[j];
//		}
		
//		System.out.println(string);
		String string = strings [index++]; 
//		String string = strings [index++] + (index == strings.length ? "error":strings [index]);
		for(int i = 0; i < string.length(); i++)
		{
			try 
			{
				buffer.put(string.charAt(i));
			} 
			catch (BufferOverflowException e) 
			{
				// TODO: handle exception
				System.out.println("缓冲区溢出！！");
				break;
			}
		}
		return true;
	}
}
