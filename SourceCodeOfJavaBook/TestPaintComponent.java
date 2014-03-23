import javax.swing.*;
import java.awt.Graphics;
public class TestPaintComponent extends JFrame
{
	public TestPaintComponent()
	{
		add(new NewLabel("banner"));
	}
	public static void main(String[] args)
	{
		TestPaintComponent frame=new TestPaintComponent();
		frame.setTitle("test graphics");
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class NewLabel extends JLabel
{
	public NewLabel(String text)
	{
		super(text);
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);//打印标签文本，调用JLabel中的paintComponent方法
	//	g.drawString("ban",100,100);
		g.drawLine(0,0,50,50);
	}
		
}
