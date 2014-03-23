import javax.swing.*;
public class HoldComponents
{
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		JButton jbtOK=new JButton("ok");

		frame.add(jbtOK);
		frame.setTitle("window 1");
		frame.setSize(300,150);
		frame.setLocation(300,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
