import javax.swing.*;
import java.awt.*;
public class TestCenterMessage extends JFrame
{
	public TestCenterMessage()
	{
		CenterMessage message=new CenterMessage();
		add(message);
		message.setBackground(Color.WHITE);
		message.setForeground(Color.RED);
		message.setFont(new Font("Californian FB",Font.BOLD,30));
	}
	public static void main(String[] args)
	{
		TestCenterMessage frame=new TestCenterMessage();
		frame.setTitle("test center message");
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
class CenterMessage extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		FontMetrics fm=g.getFontMetrics();
		int stringWidth=fm.stringWidth("Welcome to java");
		int stringAscent=fm.getAscent();

		int xCoordinate=getWidth()/2-stringWidth/2;
		int yCoordinate=getHeight()/2+stringAscent/2;

		g.drawString("Welcome to java",xCoordinate,yCoordinate);
	}
}
