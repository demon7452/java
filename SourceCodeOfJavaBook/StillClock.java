import java.awt.*;
import javax.swing.*;
import java.util.*;

public class StillClock extends JPanel
{
	private int hour;
	private int minute;
	private int second;

	public StillClock()
	{
		setCurrentTime();
	}
	public StillClock(int hour,int minute,int second)
	{
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}
	public int getHour()
	{
		return hour;
	}
	public void setHour(int hour)
	{
		this.hour=hour;
		repaint();
	}
	public int getMinute()
	{
		return minute;
	}
	public void setMinute(int minute)
	{
		this.minute=minute;
		repaint();
	}
	public int getSecond()
	{
		return second;
	}
	public void setSecond(int second)
	{
		this.second=second;
		repaint();
	}

	/**draw the clock*/
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		int clockRadius=(int)(Math.min(getWidth(),getHeight())*0.4);
		int xCenter=getWidth()/2;
		int yCenter=getHeight()/2;

		g.setFont(new Font("Courier",Font.BOLD,15));

		g.setColor(Color.black);
		g.drawOval(xCenter-clockRadius,yCenter-clockRadius,2*clockRadius,2*clockRadius);
		g.drawString("12",xCenter-5,yCenter-clockRadius+12);
		g.drawString("3",xCenter+clockRadius-10,yCenter+3);
		g.drawString("6",xCenter-3,yCenter+clockRadius-3);
		g.drawString("9",xCenter-clockRadius+3,yCenter+5);

		//draw second hand
		int sLength=(int)(clockRadius*0.9);
		int xSecond=(int)(xCenter+sLength*Math.sin(second*(2*Math.PI/60)));
		int ySecond=(int)(yCenter-sLength*Math.cos(second*(2*Math.PI/60)));
		g.setColor(Color.red);
		g.drawLine(xCenter,yCenter,xSecond,ySecond);

		//draw minute hand
		int mLength=(int)(clockRadius*0.7);
		int xMinute=(int)(xCenter+mLength*Math.sin((second/60.0+minute)*(2*Math.PI/60)));
		int yMinute=(int)(yCenter-mLength*Math.cos((second/60.0+minute)*(2*Math.PI/60)));
		g.setColor(Color.blue);
		g.drawLine(xCenter,yCenter,xMinute,yMinute);

		//draw hour hand
		int hLength=(int)(clockRadius*0.5);
		int xHour=(int)(xCenter+hLength*Math.sin((hour%12+minute/60.0+second/3600.0)*(2*Math.PI/12)));
		int yHour=(int)(yCenter-hLength*Math.cos((hour%12+minute/60.0+second/3600.0)*(2*Math.PI/12)));
		g.setColor(Color.green);
		g.drawLine(xCenter,yCenter,xHour,yHour);
	}

	public void setCurrentTime()
	{
		Calendar calendar=new GregorianCalendar();

		this.hour=calendar.get(Calendar.HOUR_OF_DAY);
		this.minute=calendar.get(Calendar.MINUTE);
		this.second=calendar.get(Calendar.SECOND);
	}
	public void renew()
	{
		setCurrentTime();
		repaint();
	}
	
	public Dimension getPerferredSize()
	{
		return new Dimension(200,200);
	}
}
