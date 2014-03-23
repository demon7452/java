import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
public class TestSwingCommonFeatures extends JFrame
{
	public TestSwingCommonFeatures()
	{
		JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT,2,2));
		JButton left=new JButton("left");
		JButton center=new JButton("center");
		JButton right=new JButton("right");
		left.setBackground(Color.BLUE);
		center.setForeground(Color.GREEN);
		right.setToolTipText("this is the right button");
		p1.add(left);
		p1.add(center);
		p1.add(right);
		p1.setBorder(new TitledBorder("three buttons"));

		Font largefont=new Font("TimesRoman",Font.BOLD,22);
		Border lineborder=new LineBorder(Color.BLACK,2);
		JPanel p2=new JPanel(new GridLayout(1,2,5,5));
		JLabel red=new JLabel("red");
		JLabel orange=new JLabel("orange");
		red.setForeground(Color.RED);
		red.setFont(largefont);
		red.setBorder(lineborder);
		orange.setForeground(Color.ORANGE);
		orange.setFont(largefont);
		orange.setBorder(lineborder);
		p2.add(red);
		p2.add(orange);
		p2.setBorder(new TitledBorder("two labels"));

		setLayout(new GridLayout(2,1,5,5));
		add(p1);
		add(p2);
	}
	public static void main(String[] args)
	{
		JFrame frame=new TestSwingCommonFeatures();
		frame.setTitle("test swing common features");
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
