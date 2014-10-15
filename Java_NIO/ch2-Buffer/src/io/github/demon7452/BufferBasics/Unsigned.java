package io.github.demon7452.BufferBasics;

import java.nio.ByteBuffer;

/**
 * 向ByteBuffer对象中获取和存放无符号的工具类
 * 这里所有的函数都是静态的，并且带有一个ByteBuffer参数
 * 由于java不提供无符号原始类型，每个从缓冲区中读出的无符号值被升到比它大的
 * 下一个基本数据类型中。
 * getUnsignedByte()返回一个short类型，
 * getUnsignedShort(),返回一个int类型，
 * 而getUnsignedInt()返回一个long型。
 * 由于没有基本类型来存储getUnsingnerLong()返回的数据，一次没有getUnsingnerLong()。
 * 如果需要返回BigInteger的函数可以执行。
 * 同样，存放函数要取一个大于它们所分配的类型的值，
 * putUnsignedByte 的参数设为short型参数。and so on!
 * @author demon7452
 * @time 2014-10-15
 */
public class Unsigned
{
	public static short getUnsignedByte (ByteBuffer buffer)
	{
		return ((short)(buffer.get() & 0xff));
	}
	
	public static void putUnsignedByte(ByteBuffer buffer, short value)
	{
		buffer.put((byte)(value & 0xff));
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
