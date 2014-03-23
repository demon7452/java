import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoveMessageDemo extends JFrame
{
	public MoveMessageDemo()
	{
		MovableMessagePanel p=new MovableMessagePanel("welcome to java");
		p.setFont(new Font("Times",Font.BOLD,90));
		p.setForeground(Color.RED);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(p);
	}
	public static void main(String[] args)
	{
		JFrame frame=new MoveMessageDemo();
		frame.setTitle("move message demo");
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	static class MovableMessagePanel extends JPanel
	{
		private String message="welcome to java";
		private int x=20;
		private int y=20;

		public MovableMessagePanel(String s)
		{
			message=s;
			addMouseMotionListener(new MouseMotionAdapter()
					{
						public void mouseDragged(MouseEvent e)
						{
							x=e.getX();
							y=e.getY();
							repaint();
						}
					});
		}
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawString(message,x,y);
		}
	}
}
