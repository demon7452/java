package io.github.demon7452.BufferBasics;

import java.nio.ByteBuffer;


public class BufferBasics {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
		
	}

}
