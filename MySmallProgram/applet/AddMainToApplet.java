import javax.swing.*;
import java.awt.*;
public class AddMainToApplet 
{
	public static void main(String[] args)
	{
		//create a frame
		JFrame frame = new JFrame();
		
		//create an instance of the applet
		LoanApplet applet = new LoanApplet();

		//add applet to the frame
		frame.add(applet,BorderLayout.CENTER);

		//Invoke init and start;
		applet.init();
		applet.start();

		//Display the frame
		frame.setTitle("add the main to applet");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
