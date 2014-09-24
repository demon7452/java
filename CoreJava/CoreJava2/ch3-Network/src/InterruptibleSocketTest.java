import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This program shows how to interrupt a socket channel
 * @author demon7452
 * @version 2014-9-24
 */
public class InterruptibleSocketTest
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			
			@Override
			public void run() 
			{
				// TODO Auto-generated method stub
				JFrame frame = new InterruptibleSocketFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
	}
}
class InterruptibleSocketFrame extends JFrame
{
	//add the three button
	private JButton interruptibleButton;
	private JButton blockingButton;
	private JButton cancleButton;
	
	private Scanner in;
	
	private JTextArea textArea;
	private Thread connectThread;
	private TestServer server;
	
	/**
	 * static final int width and height 
	 */
	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	
	/**
	 * This class handles the client input for one server socket connection 
	 */
	class TestServerHandler implements Runnable
	{
		private Socket incoming;
		private int counter;
		
		/**
		 * Constructs a handler 
		 * @param socket
		 */
		public TestServerHandler(Socket socket)
		{
			incoming = socket;
		}
		public void run()
		{
			try
			{
				OutputStream oStream = incoming.getOutputStream();
				PrintWriter out = new PrintWriter(oStream,true/*autoFlush*/);
				while(counter < 100)
				{
					counter++;
					if(counter <=10)
						out.println(counter);
					Thread.sleep(100);
				}
				incoming.close();
				textArea.append("Closing server\n");
			}
			catch(Exception e)
			{
				textArea.append("\nTestServerHandler.run: " + e);
			}
		}
	}
	/**
	 * A multithread server that listens to port 8189 and send number to the client
	 * simulating a hanging server after 10 numbers
	 */
	class TestServer implements Runnable
	{
		public void run()
		{
			try 
			{
				ServerSocket socket = new ServerSocket(8189);
				while(true)
				{
					Socket incoming = socket.accept();
					Runnable runnable = new TestServerHandler(incoming);
					Thread thread = new Thread(runnable);
					thread.start();
				}
			}
			catch (Exception e)
			{
				// TODO: handle exception
				textArea.append("\nTestServer.run" + e);
			}
		}
	}
	
	public InterruptibleSocketFrame()
	{
		setSize(WIDTH,HEIGHT);
		setTitle("InterruptibleSocketTest");
		
		JPanel buttonPanel = new JPanel();
		add(buttonPanel,BorderLayout.NORTH);
		
		textArea = new JTextArea();
		add(new JScrollPane(textArea));
		
		interruptibleButton = new JButton("Interruptible");
		blockingButton = new JButton("Blocking");
		cancleButton = new JButton("Cancel");
		cancleButton.setEnabled(false);
	
		buttonPanel.setLayout(new GridLayout(1,3));
		buttonPanel.add(interruptibleButton);
		buttonPanel.add(blockingButton);
		buttonPanel.add(cancleButton);
			
		//add button listener
		interruptibleButton.addActionListener(
		new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{	
				// TODO Auto-generated method stub
				interruptibleButton.setEnabled(false);
				blockingButton.setEnabled(false);
				cancleButton.setEnabled(true);
				connectThread = new Thread(new Runnable()
				{
					@Override
					public void run() 
					{
						// TODO Auto-generated method stub
						try 
						{
							connectInterruptibly();
						} catch (Exception e) {
							// TODO: handle exception
							textArea.append("\nInterruptibleSocketTest.connectInterruptibly:"+e);
						}
					}
				});
				connectThread.start();		
			}
		});
		blockingButton.addActionListener(
		new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});	
		cancleButton.addActionListener(
		new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	/**
	 * Connects to the test server, using interruptible I/O
	 * @throws IOException
	 */
	public void connectInterruptibly()throws IOException
	{
		textArea.append("Interruptible:\n");
		SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost",8189));
		try 
		{
			in = new Scanner(channel);
			while(!Thread.currentThread().isInterrupted())
			{
				textArea.append("Reading ");
				if(in.hasNextLine())
				{
					String lineString = in.nextLine();
					textArea.append(lineString+"\n");
				}
			}
		}
		finally
		{
			channel.close();
			EventQueue.invokeLater(new Runnable() 
			{	
				@Override
				public void run() 
				{
					// TODO Auto-generated method stub
					textArea.append("channel closed\n");
					interruptibleButton.setEnabled(true);
					blockingButton.setEnabled(true);
				}
			});
		}
	}
	/**
	 * connects to the test server,using blocking I/O
	 * @throws IOException
	 */
	public void connectBlocking() throws IOException
	{
		textArea.append("Blocking:\n");
		Socket socket = new Socket("localhost",8189);
		try 
		{
			in = new Scanner(socket.getInputStream());
			while(!Thread.currentThread().isInterrupted())
			{
				textArea.append("reading ");
				if(in.hasNextLine())
				{
					String liString = in.nextLine();
					textArea.append(liString + "\n");
				}
			}
		}
		finally
		{
			socket.close();
			EventQueue.invokeLater(new Runnable()
			{
				
				@Override
				public void run()
				{
					// TODO Auto-generated method stub
					textArea.append("socket closed\n");
					interruptibleButton.setEnabled(true);
					blockingButton.setEnabled(true);
				}
			});
		}
	}
}



































