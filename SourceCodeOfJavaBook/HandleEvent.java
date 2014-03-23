import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HandleEvent extends JFrame
{
	public HandleEvent()
	{
	FlowLayout layout=new FlowLayout();
	setLayout(layout);

	JButton jbtOK=new JButton("ok");
	JButton jbtCancel=new JButton("cancel");
	add(jbtOK);
	add(jbtCancel);

	OkListenerClass listenerOK=new OkListenerClass();
	jbtOK.addActionListener(listenerOK);

	CancelListenerClass listenerCancel=new CancelListenerClass();
	jbtCancel.addActionListener(listenerCancel);
	}
	public static void main(String[] args)
	{
		JFrame frame=new HandleEvent();
		frame.setTitle("handle event");
		frame.setSize(300,300);
		frame.setLocation(200,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class OkListenerClass implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("ok button clicked");
	}
}
class CancelListenerClass implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("cancel button clicked");
	}
}

