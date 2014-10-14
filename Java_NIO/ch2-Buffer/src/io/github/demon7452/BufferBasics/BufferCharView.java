package io.github.demon7452.BufferBasics;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

/**
 * test asCharBuffer view
 * 测试char字符视图缓冲区
 * @author demon7452
 * @time 2014-10-13
 */
public class BufferCharView
{
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ByteBuffer byteBuffer = ByteBuffer.allocate(7);//分配7个byte空间
		byteBuffer.order(ByteOrder.BIG_ENDIAN);//大端字节顺序
		CharBuffer charBuffer = byteBuffer.asCharBuffer();//创建char字符视图缓冲区
		
		//Load the ByteBuffer with some bytes
		byteBuffer.put(0,(byte)0);
		byteBuffer.put(1,(byte)'H');
		byteBuffer.put(2,(byte)0);
		byteBuffer.put(3,(byte)'i');
		byteBuffer.put(4,(byte)0);
		byteBuffer.put(5,(byte)'!');
		byteBuffer.put(6,(byte)'!');
		
		println(byteBuffer);
		drainBuffer(byteBuffer);
		println(charBuffer);
		drainBuffer(charBuffer);
		
	}
	
	/*
	 * print into about a buffer
	 */
	public static void println(Buffer buffer)
	{
		System.out.println("position:" + buffer.position() + " limit:"
				+ buffer.limit() + " capacity:" + buffer.capacity() + " : '"
				+ buffer.toString() + "'");
	}
	/*
	 * print into about a byte buffer
	 */
	public static void drainBuffer(ByteBuffer buffer)
	{
		while(buffer.hasRemaining())
		{
			System.out.print((char)buffer.get());
		}
		System.out.print("\n");
	}	
	/*
	 * print into about a char buffer
	 */
	public static void drainBuffer(CharBuffer buffer)
	{
		while(buffer.hasRemaining())
		{
			System.out.print(buffer.get());
		}
		System.out.print("\n");
	}

}
