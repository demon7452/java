import javax.swing.*;
import java.awt.Graphics;
public class TestGetGraphics extends JFrame
{
	private JLabel jlbBanner=new JLabel("banner");
	public TestGetGraphics()
	{
		add(jlbBanner);
		System.out.println(jlbBanner.getGraphics());
	}
	public static void main(String[] args)
	{
		TestGetGraphics frame=new TestGetGraphics();
		frame.setTitle("test graphics");
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null,"continue");
		Graphics graphics=frame.jlbBanner.getGraphics();
		graphics.drawLine(0,0,50,50);
	}
}
