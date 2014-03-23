import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TestColorGUI extends JFrame
{
	public TestColorGUI()
	{
		setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
		
		GraphicsEnvironment e=GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontNames=e.getAvailableFontFamilyNames();
		Font font=new Font("Dialog",Font.BOLD,22);
		for(int i=0;i<fontNames.length;i++)
		{
			JButton name=new JButton(fontNames[i]);
			add(name);
			name.setForeground(Color.RED);
			name.setFont(font);
		}	
	}
	public static void main(String[] args)
	{
		JFrame frame=new TestColorGUI();
		frame.setTitle("test color");
		frame.setLocationRelativeTo(null);
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
