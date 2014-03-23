import javax.swing.*;
import java.awt.event.*;

public class ClockAnimation extends StillClock
{
	public ClockAnimation()
	{
		Timer timer=new Timer(1000,new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						setCurrentTime();
						repaint();
					}
				});
		timer.start();
	}
	/**
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setCurrentTime();
			repaint();
		}
	}*/
	public static void main(String[] args)
	{
		JFrame frame=new JFrame("clock animation");
		ClockAnimation clock =new ClockAnimation();
		frame.add(clock);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
