package ch3.ChannelBasics;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Test copying between channels
 * @author lixiong
 * @date 2014-10-21
 */
public class ChannelCopy
{
	/**
	 * This code copies data from standard input to standard output. Like the 'cat'
	 * command, but without any useful options. 
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		ReadableByteChannel source = Channels.newChannel(System.in);
		WritableByteChannel dest = Channels.newChannel(System.out);
		
//		channelCopy1(source, dest);
		channelCopy2(source, dest);
		//alternatively, call channelCopy2 (src,dest)
		source.close();
		dest.close();

	}

	/**
	 * Channel copy method 1. this method copies data from the src 
	 * channel and writes it to the destination channel until EOF(end of file) on src.
	 * This implementation makes use of compact() on the temp buffer to pack down 
	 * the data if the buffer wasn't fully drained. This may result in data copying,
	 * but minimizes system calls. It also requires a cleanup loop to make sure all the data gets sent.
	 * @param src ,source channel
	 * @param dest,destination channel
	 * @throws IOException
	 */
	private static void channelCopy1 (ReadableByteChannel src,WritableByteChannel dest) throws IOException
	{
		ByteBuffer buffer = ByteBuffer.allocateDirect(4);
		while(src.read(buffer) != -1)
		{
			//Prepare the buffer to be drained
			buffer.flip();
			//write to the channel; may block
			int st = dest.write(buffer);
			System.out.println(st);
			//if partial transfer , shift remainder down
			//if buffer is empty , same as doing clear();
			buffer.compact();//丢弃已释放的数据，保留未释放的数据，并使缓冲区对重新填充容量准备就绪.
		}
		//EOF end of file will leave buffer in fill state
		buffer.flip();
		//make sure that the buffer is fully drained
		while(buffer.hasRemaining())
		{
			int re =dest.write(buffer);
			System.out.println(re);
		}
	}
	
	/**
	 * Channel copy method 2. This method performs the same copy, but assures the 
	 * temp buffer is empty before reading more data. This nerver requires data copying
	 * but may result in more systems calls.No post-loop cleanup is needed because the buffer
	 * will be empty when the loop is exited.
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	private static void channelCopy2(ReadableByteChannel src, WritableByteChannel dest) throws IOException
	{
		ByteBuffer buffer = ByteBuffer.allocateDirect(4);
		while(src.read(buffer) != -1)
		{
			//prepare the buffer to be drained
			buffer.flip();
			//make sure that the buffer was fully drained
			while(buffer.hasRemaining())
			{
				int num = dest.write(buffer);
				System.out.println(num);
			}
			//Make the buffer empty , ready for filling
			buffer.clear();
		}
	}
	
	
	
	
	
	
}
