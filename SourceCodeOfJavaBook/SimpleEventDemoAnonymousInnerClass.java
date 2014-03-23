import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleEventDemoAnonymousInnerClass extends JFrame
{
	public SimpleEventDemoAnonymousInnerClass()
	{
		JButton jbtOK=new JButton("OK");
		setLayout(new FlowLayout());
		add(jbtOK);

		jbtOK.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.out.println(e.getActionCommand());
						java.util.Date date=new java.util.Date(e.getWhen());
						System.out.println(date.toString());
					}
				});
	}
	public static void main(String[] args)
	{
		JFrame frame=new SimpleEventDemoAnonymousInnerClass();
		frame.setTitle("simple event demo inner class");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
