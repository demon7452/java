import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplaySaber extends JFrame
{
	public DisplaySaber()
	{
		add(new Saber());
	}
	public static void main(String[] args)
	{
		DisplaySaber frame=new DisplaySaber();
		frame.setTitle("display saber");
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	static class Saber extends JPanel
	{
		private ImageIcon imageIcon=new ImageIcon("image/3.jpg");
		private Image image=imageIcon.getImage();
		private int x=getWidth()/2;
		private int y=getHeight()/2;
		private Timer timer=new Timer(1000,new TimerListener());

		public Saber()
		{
			timer.start();
		}
		public void paintComponent(Graphics g)
		{
			g.drawImage(image,x,y,300,300,this);
		}
		class TimerListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				x=(int)(getWidth()*Math.random());
				y=(int)(getHeight()*Math.random());
				repaint();
			}
		}

	}
}
