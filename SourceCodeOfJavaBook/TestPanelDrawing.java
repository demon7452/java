import javax.swing.*;
import java.awt.Graphics;
public class TestPanelDrawing extends JFrame
{
	public TestPanelDrawing()
	{
		add(new NewPanel());
	}
	public static void main(String[] args)
	{
		TestPanelDrawing frame=new TestPanelDrawing();
		frame.setTitle("test panel drawing");
		frame.setSize(200,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class NewPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawLine(0,0,50,50);
		g.drawString("banner",0,100);
	}
}
