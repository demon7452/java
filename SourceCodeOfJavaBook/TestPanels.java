import java.awt.*;
import javax.swing.*;
public class TestPanels extends JFrame
{
	public TestPanels()
	{
		//create panel p1
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(4,3));
		for(int i=1;i<=9;i++)
		{
			JButton b=new JButton(""+i);
			p1.add(b);
			set(b);
		}
		JButton jbt0=new JButton(""+0);
		set(jbt0);
		p1.add(jbt0);
		JButton jbt1=new JButton("Start");
		set(jbt1);
		p1.add(jbt1);
		JButton jbt2=new JButton("Stop");
		set(jbt2);
		p1.add(jbt2);

		//create panel p2
		JPanel p2=new JPanel();
		p2.setLayout(new BorderLayout());
		JTextField jtf=new JTextField("time to be displayed here");
		set(jtf);
		p2.add(jtf,BorderLayout.NORTH);
		p2.add(p1,BorderLayout.CENTER);

		//add contents into frame
		add(p2,BorderLayout.EAST);
		add(new JButton("food to be placed here"),BorderLayout.CENTER);

	}
	//set font and color
	public void set(JComponent b)
	{
		Font font=new Font("DialogInput",Font.BOLD,33);
		b.setFont(font);
		b.setForeground(Color.RED);
	}
	/**Main Method*/
	public static void main(String[] args)
	{
		JFrame frame=new TestPanels();
		frame.setTitle("the front view of a microwave oven");
		frame.setLocationRelativeTo(null);
		frame.setSize(400,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

