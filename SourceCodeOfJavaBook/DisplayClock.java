import java.awt.*;
import javax.swing.*;
import java.util.*;

public class DisplayClock extends JFrame
{
	public DisplayClock()
	{
		StillClock clock=new StillClock(9,30,30);

		String minute=(clock.getMinute()>9)?(""+clock.getMinute()):("0"+clock.getMinute());
		String second=(clock.getSecond()>9)?(""+clock.getSecond()):("0"+clock.getSecond());
		String message=clock.getHour()+":"+minute+":"+second;
		MessagePanel messagePanel=new MessagePanel(message,true);
		messagePanel.setForeground(Color.blue);
		messagePanel.setFont(new Font("Courier",Font.BOLD,16));
		
		add(clock);
		add(messagePanel,BorderLayout.SOUTH);
	}
	public static void main(String[] args)
	{
		DisplayClock frame=new DisplayClock();
		frame.setTitle("display clock");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setVisible(true);
	}
}
