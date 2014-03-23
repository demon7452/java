import javax.swing.*;
import java.awt.*;
public class DrawPolygon extends JFrame
{
	public DrawPolygon()
	{
		setLayout(new GridLayout(2,1,5,5));
		add(new PolygonsPanel(PolygonsPanel.LINE));
		add(new PolygonsPanel(PolygonsPanel.GON));
	}
	public static void main(String[] args)
	{
		DrawPolygon frame=new DrawPolygon();
		frame.setTitle("test drawPolygon");
		frame.setSize(100,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class PolygonsPanel extends JPanel
{
	public static final int LINE=1;
	public static final int GON=2;
	private int type=1;
	public PolygonsPanel(int type)
	{
		this.type=type;
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int xCenter=getWidth()/2;
		int yCenter=getHeight()/2;
		int radius=(int)(Math.min(getWidth(),getHeight())*0.4);

		Polygon polygon=new Polygon();
		g.setColor(Color.RED);

		polygon.addPoint(xCenter+radius,yCenter);
		polygon.addPoint(xCenter+(int)(radius*Math.cos(Math.PI/3)),yCenter-(int)(radius*Math.sin(Math.PI/3)));
		polygon.addPoint(xCenter+(int)(radius*Math.cos(2*Math.PI/3)),yCenter-(int)(radius*Math.sin(2*Math.PI/3)));
		polygon.addPoint(xCenter+(int)(radius*Math.cos(3*Math.PI/3)),yCenter-(int)(radius*Math.sin(3*Math.PI/3)));
		polygon.addPoint(xCenter+(int)(radius*Math.cos(4*Math.PI/3)),yCenter-(int)(radius*Math.sin(4*Math.PI/3)));
		polygon.addPoint(xCenter+(int)(radius*Math.cos(5*Math.PI/3)),yCenter-(int)(radius*Math.sin(5*Math.PI/3)));

		int[] x={xCenter+radius,xCenter+(int)(radius*Math.cos(Math.PI/3)),xCenter+(int)(radius*Math.cos(2*Math.PI/3)),xCenter+(int)(radius*Math.cos(3*Math.PI/3)),xCenter+(int)(radius*Math.cos(4*Math.PI/3)),xCenter+(int)(radius*Math.cos(5*Math.PI/3))};
		int[] y={yCenter,yCenter-(int)(radius*Math.sin(Math.PI/3)),yCenter-(int)(radius*Math.sin(2*Math.PI/3)),yCenter-(int)(radius*Math.sin(3*Math.PI/3)),yCenter-(int)(radius*Math.sin(4*Math.PI/3)),yCenter-(int)(radius*Math.sin(5*Math.PI/3))};

		switch(type)
		{
			case LINE:
				g.drawPolyline(x,y,x.length);
				break;
			case GON:
				g.fillPolygon(polygon);
		}
	}
}
