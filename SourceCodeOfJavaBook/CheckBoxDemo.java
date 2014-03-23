import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxDemo extends ButtonDemo
{
	private JCheckBox jchkCentered=new JCheckBox("Centered");
	private JCheckBox jchkBold=new JCheckBox("Bold");
	private JCheckBox jchkItalic=new JCheckBox("Italic");
	public CheckBoxDemo()
	{
		jchkCentered.setMnemonic('C');
		jchkBold.setMnemonic('B');
		jchkItalic.setMnemonic('I');

		JPanel jpCheckBox=new JPanel();
		jpCheckBox.setLayout(new GridLayout(3,1));
		jpCheckBox.add(jchkCentered);
		jpCheckBox.add(jchkBold);
		jpCheckBox.add(jchkItalic);
		add(jpCheckBox,BorderLayout.EAST);

		jchkCentered.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						messagePanel.setCentered(jchkCentered.isSelected());
					}
				});
		jchkBold.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						setNewFont();
					}
				});
		jchkItalic.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						setNewFont();
					}
				});
	}
	public static void main(String[] args)
	{
		CheckBoxDemo frame=new CheckBoxDemo();
		frame.setTitle("Check box demo");
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void setNewFont()
	{
		int fontStyle=Font.PLAIN;
		fontStyle+=(jchkBold.isSelected()?Font.BOLD:Font.PLAIN);
		fontStyle+=(jchkItalic.isSelected()?Font.ITALIC:Font.PLAIN);

		Font font=messagePanel.getFont();
		messagePanel.setFont(new Font(font.getName(),fontStyle,font.getSize()));
	}
}
