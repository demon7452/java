import javax.swing.*;
public class DisplayMessage extends JApplet
{
	public void init()
	{
		//Get parameter values from the HTML file
		String message = getParameter("MESAGE");
		int x = Integer.parseInt(getParameter("X"));
		int y = Integer.parseInt(getParameter("Y"));

		//create a message panel
		MessagePanel messagePanel = new MessagePanel(message);
		messagePanel.setXCoordinate(x);
		messagePanel.setYCoordinate(y);

		//add the message panel to the applet
		add(messagePanel);
	}
}
