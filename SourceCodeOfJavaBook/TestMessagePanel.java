import javax.swing.*;
import java.awt.*;
public class TestMessagePanel extends JFrame
{
	public TestMessagePanel()
	{
		MessagePanel p1=new MessagePanel("welcome to java",true);
		MessagePanel p2=new MessagePanel("java is fun",true);
		MessagePanel p3=new MessagePanel("java is cool");
		MessagePanel p4=new MessagePanel("i love java");

		p1.setFont(new Font("SansSerif",Font.BOLD,20));
		p2.setFont(new Font("Courier",Font.ITALIC,20));
		p3.setFont(new Font("Times",Font.BOLD,20));
		p4.setFont(new Font("Californian",Font.PLAIN,20));

		p1.setBackground(Color.red);
		p2.setBackground(Color.cyan);
		p3.setBackground(Color.green);
		p4.setBackground(Color.white);

		setLayout(new GridLayout(2,2,10,10));
		add(p1);
		add(p2);
		add(p3);
		add(p4);
	}
	public static void main(String[] args)
	{
		TestMessagePanel frame=new TestMessagePanel();
		frame.setTitle("test message panel");
		frame.setSize(400,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
