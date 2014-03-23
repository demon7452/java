import javax.swing.*;
import java.awt.*;
public class TestImageIcon extends JFrame
{
	private ImageIcon image1=new ImageIcon("image/1.jpg");
	private ImageIcon image2=new ImageIcon("image/2.jpg");
	private ImageIcon image3=new ImageIcon("image/3.jpg");
	private ImageIcon image4=new ImageIcon("image/4.jpg");
	public TestImageIcon()
	{
		setLayout(new GridLayout(1,4,5,5));
		JLabel label1=new JLabel(image1);
		JLabel label2=new JLabel(image2);
		JButton button1=new JButton(image3);
		JButton button2=new JButton(image4);

		add(label1);
		add(label2);
		add(button1);
		add(button2);
	}
	public static void main(String[] args)
	{
		JFrame frame=new TestImageIcon();
		frame.setTitle("test image icon");
		frame.setSize(800,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
