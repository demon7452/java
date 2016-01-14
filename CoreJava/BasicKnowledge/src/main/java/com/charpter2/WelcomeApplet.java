package com.charpter2;

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

public class WelcomeApplet extends JApplet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init()
	{
		EventQueue.invokeLater(new Runnable()
		{
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				setLayout(new BorderLayout());
				
				JLabel label = new JLabel(getParameter("greeting"),SwingConstants.CENTER);
				label.setFont(new Font("Serif", Font.BOLD, 18));
				add(label,BorderLayout.CENTER);
				
				JPanel panel = new JPanel();
				
				JButton baiduButton = new JButton("Baidu");
				baiduButton.addActionListener(makeAction("http://www.baidu.com"));
				panel.add(baiduButton);
				
				JButton googleButton = new JButton("Google");
				googleButton.addActionListener(makeAction("https://www.google.com"));
				panel.add(googleButton);
				
				add(panel, BorderLayout.SOUTH);
			}
		});
	}
	
	private ActionListener makeAction(final String urlString)
	{
		return new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				try
				{
					getAppletContext().showDocument(new URL(urlString));
				} catch (MalformedURLException exception)
				{
					// TODO: handle exception
					exception.printStackTrace();
				}
				
			}
		};
	}

}
