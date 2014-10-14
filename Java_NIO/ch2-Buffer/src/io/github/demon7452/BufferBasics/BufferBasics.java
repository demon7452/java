package io.github.demon7452.BufferBasics;

import java.nio.ByteBuffer;
/**
 * learning the buffer basics and make a test
 * @author demon7452
 * @version 2014-9-29
 */
public class BufferBasics 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.put((byte) 'H').put((byte) 'e').put((byte) 'l').put((byte) 'l')
				.put((byte) 'o');
		buffer.put((byte)'W');
		buffer.put((byte)'o');
		buffer.put((byte)'r');
		buffer.put((byte)'l');
		buffer.put((byte)'d');
//		buffer.put((byte)'d');//溢出
//		buffer.limit(buffer.position());//将上界属性值limit设为当前属性值position,即缓冲区有效内容的末端
//		buffer.position(0);//将当前属性值position设为0;
		buffer.flip();//缓冲区翻转，相当于buffer.limit(buffer.position()).position(0);等价于上面两句
		while(buffer.hasRemaining())
		{
			char charByte = (char)buffer.get();
			System.out.print(charByte);
		}
		System.out.println("\n"+(char)buffer.get(5));
//		buffer.put(5,((byte)'k'));//替换
//		System.out.println((char)buffer.get(5));
		buffer.position(0);		
		buffer.limit(5);
		while(buffer.hasRemaining())
		{
			char charByte = (char)buffer.get();
			System.out.print(charByte);
		}

	}

}
