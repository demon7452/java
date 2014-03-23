import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SimpleEventdemo extends JFrame
{
	public SimpleEventdemo()
	{
		JButton jbtOK=new JButton("OK");
		setLayout(new FlowLayout());
		add(jbtOK);

		ActionListener listener=new OKListener();
		jbtOK.addActionListener(listener);
	}
	public static void main(String[] args)
	{
		SimpleEventdemo frame=new SimpleEventdemo();
		frame.setTitle("simple event demo");
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class OKListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println(e.getActionCommand());
		java.util.Date date=new java.util.Date(e.getWhen());
		System.out.println(date.toString());
	}
}
