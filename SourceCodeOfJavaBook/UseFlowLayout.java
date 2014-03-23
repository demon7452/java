import javax.swing.*;
import java.awt.*;
public class UseFlowLayout
{
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		FlowLayout layout=new FlowLayout();
		frame.setLayout(layout);

		JButton jbtOK=new JButton("ok");
		JButton jbtCancel=new JButton("cancel");

		frame.add(jbtOK);
		frame.add(jbtCancel);

		frame.setTitle("window 1");
		frame.setSize(300,100);
		frame.setLocation(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
