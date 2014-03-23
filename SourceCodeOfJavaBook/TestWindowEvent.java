import java.awt.event.*;
import javax.swing.*;

public class TestWindowEvent extends JFrame
{
	public TestWindowEvent()
	{
		addWindowListener(new WindowListener()
				{
					public void windowClosing(WindowEvent event)
					{
						System.out.println("window closing");
					}
					public void windowOpened(WindowEvent event)
					{
						System.out.println("window opened");
					}
					public void windowIconified(WindowEvent event)
					{
						System.out.println("window iconified");
					}
					public void windowDeiconified(WindowEvent event)
					{
						System.out.println("window deiconified");
					}
					public void windowClosed(WindowEvent event)
					{
						System.out.println("window closed");
					}
					public void windowActivated(WindowEvent event)
					{
						System.out.println("window actived");
					}
					public void windowDeactivated(WindowEvent event)
					{
						System.out.println("window deactived");
					}
				});
	}
	public static void main(String[] args)
	{
		JFrame frame=new TestWindowEvent();
		frame.setTitle("test window event");
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
