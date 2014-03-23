import javax.swing.*;
import java.awt.*;
public class CustomFrame extends JFrame
{
	public CustomFrame()
	{
		FlowLayout layout=new FlowLayout();
		setLayout(layout);

		JButton jbtOK=new JButton("ok");
		JButton jbtCancel=new JButton("cancel");

		add(jbtOK);
		add(jbtCancel);
		setTitle("windows 1");
		setSize(300,300);
		setLocation(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		JFrame frame=new CustomFrame();
	}
}
