import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleEventDemoInnerClass extends JFrame
{
	public SimpleEventDemoInnerClass()
	{
		JButton jbtOK=new JButton("OK");
		setLayout(new BorderLayout());
		add(jbtOK,BorderLayout.CENTER);

		ActionListener listener=new OKListener();
		jbtOK.addActionListener(listener);
	}
	public static void main(String[] args)
	{
		JFrame frame=new SimpleEventDemoInnerClass();
		frame.setTitle("simple event demo inner class");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	private class OKListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println(e.getActionCommand());
			java.util.Date date=new java.util.Date(e.getWhen());
			System.out.println(date.toString());
		}
	}
}
