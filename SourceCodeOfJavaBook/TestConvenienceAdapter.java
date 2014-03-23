import javax.swing.JFrame;
import java.awt.event.*;
public class TestConvenienceAdapter extends JFrame
{
	public TestConvenienceAdapter()
	{
		addWindowListener(new WindowAdapter()
				{
					public void windowActivated(WindowEvent event)
					{
						System.out.println("window activated");
					}
				});
	}
	public static void main(String[] args)
	{
		JFrame frame=new TestConvenienceAdapter();
		frame.setTitle("test convenience adapter");
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
