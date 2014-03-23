import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TestGUI
{
	public static void main(String[] args)
	{
	JFrame frame=new JFrame();
	FlowLayout layout=new FlowLayout();
	frame.setLayout(layout);

	JButton jbtOK=new JButton("ok");
	frame.add(jbtOK);


	JLabel jlbName=new JLabel("enter your name");
	frame.add(jlbName);

	JTextField jtfName=new JTextField("type your name");
	frame.add(jtfName);

	JCheckBox jchkBold=new JCheckBox("bold");
	frame.add(jchkBold);

	JRadioButton jrbRed=new JRadioButton("red");
	frame.add(jrbRed);

	JComboBox jcbColor=new JComboBox(new String[]{"red","green","blue"});
	frame.add(jcbColor);

	JButton jbtClose=new JButton("¹Ø±Õ");
	frame.add(jbtClose);
	CloseListener l=new CloseListener();
	jbtClose.addActionListener(l);

	frame.setTitle("test GUI");
	frame.setSize(400,200);
	frame.setLocation(400,200);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	}
}
class CloseListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
}
