import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AnimationDemo extends JFrame
{
	public AnimationDemo()
	{
		add(new MovingMessagePanel("moving message?"));
	}
	public static void main(String[] args)
	{
		AnimationDemo frame=new AnimationDemo();
		frame.setTitle("animation demo");
		frame.setSize(400,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	static class MovingMessagePanel extends JPanel
	{
		private String message="welcome to java";
		private int x=0;
		private int y=80;

		private	Timer timer=new Timer(1000,new TimerListener());
		public MovingMessagePanel(String message)
		{
			this.message=message;
			timer.start();
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			if(x>getWidth())
			{
				x=-20;
			}
			x+=15;
			g.drawString(message,x,y);
		}
		class TimerListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				repaint();
			}
		}
	}
}
