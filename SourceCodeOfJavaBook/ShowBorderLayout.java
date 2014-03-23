import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class ShowBorderLayout extends JFrame
{
	public ShowBorderLayout()
	{
		setLayout(new BorderLayout(5,10));
		add(new JButton("east"),BorderLayout.EAST);
		add(new JButton("SOUTH"),BorderLayout.SOUTH);
		add(new JButton("NORTH"),BorderLayout.NORTH);
		add(new JButton("WEST"),BorderLayout.WEST);
		add(new JButton("CENTER"),BorderLayout.CENTER);
	}
	public static void main(String[] args)
	{
		ShowBorderLayout frame=new ShowBorderLayout();
		frame.setTitle("showBorderLayout");
		frame.setLocationRelativeTo(null);
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	





}