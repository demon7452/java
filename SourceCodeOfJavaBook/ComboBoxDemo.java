import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxDemo extends JFrame
{
	private ImageIcon[] operaImage={new ImageIcon("opera/1.gif"),new ImageIcon("opera/2.gif"),new ImageIcon("opera/3.gif"),new ImageIcon("opera/4.gif"),new ImageIcon("opera/5.gif"),new ImageIcon("opera/6.gif"),new ImageIcon("opera/7.gif")};
	private String[] operaTitles={"opera1","opera2","opera3","opera4","opera5","opera6","opera7"};
	private String[] operaText={"description for opera1","description for opera2","description for opera3","description for opera4","description for opera5","description for opera6","description for opera7"};

	private DescriptionPanel descriptionPanel=new DescriptionPanel();
	private JComboBox jcbo=new JComboBox(operaTitles);
	
	public ComboBoxDemo()
	{
		setDisplay(0);
		setLayout(new BorderLayout());
		add(jcbo,BorderLayout.NORTH);
		add(descriptionPanel,BorderLayout.CENTER);
		
		jcbo.addItemListener(new ItemListener()
				{
					public void itemStateChanged(ItemEvent e)
					{
						setDisplay(jcbo.getSelectedIndex());
					}
				});
		System.out.println(operaText[0]);
	}
	public static void main(String[] args)
	{
		ComboBoxDemo frame=new ComboBoxDemo();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("combo box demo");
		frame.setVisible(true);
	}
	public void setDisplay(int index)
	{
		descriptionPanel.setTitle(operaTitles[index]);
		descriptionPanel.setImageIcon(operaImage[index]);
		descriptionPanel.setDescription(operaText[index]);
	}
}
