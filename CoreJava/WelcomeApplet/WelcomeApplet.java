import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This applet displays a greeting from the authors.
 * @version 2014-8-19
 * @author demon7452
 *
 */
public class WelcomeApplet extends JApplet
{
	public void init()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				setLayout(new BorderLayout());
				

				
//				add label 
				JLabel label = new JLabel(getParameter("greeting"),SwingConstants.CENTER);
//				label.setFont("Serif", Font.BOLD, 18); wrong
				label.setFont(new Font("Serif",Font.BOLD,18));
				add(label,BorderLayout.CENTER);
				
				
//				add panel
				JPanel panel = new JPanel();
				
//				add button to web url
				JButton jbtWeb = new JButton("WebURL");
				jbtWeb.addActionListener(makeAction("https://github.com/demon7452"));
				panel.add(jbtWeb);
				
//				add button for email
				JButton jbtEmail = new JButton("Email");
				jbtEmail.addActionListener(makeAction("mailto:demonli7452@gmail.com"));
				panel.add(jbtEmail);
				
				add(panel,BorderLayout.SOUTH);
			}
		});
	}
	private ActionListener makeAction(final String text)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					getAppletContext().showDocument(new URL(text));
				}
				catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
			}
		};
	}
}
