import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class ShowFlowLayout extends JFrame
{
	public ShowFlowLayout()
	{
		setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
		add(new JLabel("first name"));
		add(new JTextField(8));
		add(new JLabel("mi"));
		add(new JTextField(10));
		add(new JLabel("last name"));
		add(new JTextField(8));
	}
	public static void main(String[] args)
	{
		ShowFlowLayout frame=new ShowFlowLayout();
		JButton jbtOK=new JButton("ok");
		frame.add(jbtOK);

	
		frame.setTitle("showFlowLayout");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,200);
		frame.setVisible(true);
	}
}
