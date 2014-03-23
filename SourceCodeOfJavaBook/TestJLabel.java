import javax.swing.*;
import java.awt.*;

public class TestJLabel extends JFrame
{
	public static void main(String[] args)
	{
		ImageIcon icon=new ImageIcon("image/1.jpg");
		JLabel  jlbl=new JLabel("saber",icon,SwingConstants.LEFT);

		jlbl.setHorizontalTextPosition(SwingConstants.RIGHT);
		jlbl.setVerticalTextPosition(SwingConstants.CENTER);
		jlbl.setIconTextGap(30);

		JFrame frame=new JFrame();
		frame.add(jlbl);
		frame.setTitle("test jlabel");
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
