import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;

public class DrawArcs extends JFrame
{
	public DrawArcs()
	{
		setTitle("DrawArcs");
		setLayout(new GridLayout(2,1,10,10));
		add(new ArcsPanel());
		add(new ArcsPanel(true));
	}
	public static void main(String[] args)
	{
		DrawArcs frame=new DrawArcs();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(250,300);
    frame.setVisible(true);
     }
     
}
class ArcsPanel extends JPanel
{
	private boolean filled=false;
	public ArcsPanel()
	{
	}
	public ArcsPanel(boolean filled)
	{
		this.filled=filled;
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int xCenter=getWidth()/2;
		int yCenter=getHeight()/2;
		int radius=(int)(Math.min(getWidth(),getHeight())*0.4);
		
		int x=xCenter-radius;
		int y=yCenter-radius;
		
		g.setColor(Color.RED);
		if(filled)
		{
			g.fillArc(x,y,2*radius,2*radius,0,30);
		  g.fillArc(x,y,2*radius,2*radius,90,30);
			g.fillArc(x,y,2*radius,2*radius,180,30);
			g.fillArc(x,y,2*radius,2*radius,270,30);
		}
		else
		{
			g.drawArc(x,y,2*radius,2*radius,0,30);
			g.drawLine(xCenter,yCenter,xCenter+radius,yCenter);
			g.drawLine((int)(xCenter+radius*Math.sqrt(3)/2),(int)(yCenter-0.5*radius),xCenter,yCenter);
		  g.drawArc(x,y,2*radius,2*radius,90,30);
			g.drawLine(xCenter,yCenter,xCenter,yCenter-radius);
			g.drawLine((int)(xCenter-radius*0.5),(int)(yCenter-Math.sqrt(3)/2*radius),xCenter,yCenter);
			g.drawArc(x,y,2*radius,2*radius,180,30);
			g.drawLine(xCenter,yCenter,xCenter-radius,yCenter);
			g.drawLine((int)(xCenter-radius*Math.sqrt(3)/2),(int)(yCenter+0.5*radius),xCenter,yCenter);
			g.drawArc(x,y,2*radius,2*radius,270,30);
			g.drawLine(xCenter,yCenter,xCenter,yCenter+radius);
			g.drawLine((int)(xCenter+radius*0.5),(int)(yCenter+Math.sqrt(3)/2*radius),xCenter,yCenter);
		}
	}
}
