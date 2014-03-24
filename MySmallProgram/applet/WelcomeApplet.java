//WelcomeApplet.java:Applet for displaying a message
import javax.swing.*;
public class WelcomeApplet extends JApplet
{
	/** initialize the applet */
	public void init()
	{
		add(new JLabel("Welcome to java", JLabel.CENTER));
	}
}

