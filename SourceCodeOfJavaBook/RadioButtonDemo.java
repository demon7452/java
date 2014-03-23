import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends CheckBoxDemo
{
	private JRadioButton jrbRed=new JRadioButton("Red");
	private JRadioButton jrbBlue=new JRadioButton("Blue");
	private JRadioButton jrbGreen=new JRadioButton("Green");
	public RadioButtonDemo()
	{
		JPanel jpRadioButtons=new JPanel();
		jpRadioButtons.setLayout(new GridLayout(3,1));
		jpRadioButtons.add(jrbRed);
		jpRadioButtons.add(jrbBlue);
		jpRadioButtons.add(jrbGreen);
		add(jpRadioButtons,BorderLayout.WEST);

		ButtonGroup group=new ButtonGroup();
		group.add(jrbRed);
		group.add(jrbBlue);
		group.add(jrbGreen);

		jrbRed.setMnemonic('R');
		jrbBlue.setMnemonic('B');
		jrbGreen.setMnemonic('G');
		
		jrbRed.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						messagePanel.setForeground(Color.RED);
					}
				});
		jrbBlue.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						messagePanel.setForeground(Color.BLUE);
					}
				});
		jrbGreen.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						messagePanel.setForeground(Color.GREEN);
					}
				});

		jrbGreen.setSelected(true);
		messagePanel.setForeground(Color.GREEN);
	}
	public static void main(String[] args)
	{
		RadioButtonDemo frame=new RadioButtonDemo();
		frame.setTitle("radio button demo");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
