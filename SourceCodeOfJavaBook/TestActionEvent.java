import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestActionEvent extends JFrame
{
	public TestActionEvent()
	{
		JButton jbtOK=new JButton("OK");
		JButton jbtCancel=new JButton("Cancel");
		setLayout(new FlowLayout());
		add(jbtOK);
		add(jbtCancel);

		jbtOK.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("the "+e.getActionCommand()+" button is clicked at\n"+new java.util.Date(e.getWhen()));
					}
				});
		jbtCancel.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("the "+e.getActionCommand()+" button is clicked at\n"+new java.util.Date(e.getWhen()));
					}
				});
	}
	public static void main(String[] args)
	{
		JFrame frame=new TestActionEvent();
		frame.setTitle("test action event");
		frame.setSize(200,100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
