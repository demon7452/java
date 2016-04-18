package com.chapter02.javaProgrammingEnvironment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImageViewer 
{
	public static void main(String[] args)
	{
		JFrame frame = new ImageViewerFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class ImageViewerFrame extends JFrame
{
	private static final long serialVersionUID = -3390432788467225354L;
	
	private JLabel label;
	private JFileChooser fileChooser;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	
	public ImageViewerFrame()
	{
		setTitle("ImageViewer");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		label = new JLabel();
		add(label);
		
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("."));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem openItem = new JMenuItem("open");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				int result = fileChooser.showOpenDialog(null);
				if(JFileChooser.APPROVE_OPTION == result)
				{
					String filePath = fileChooser.getSelectedFile().getPath();
					label.setIcon(new ImageIcon(filePath));
				}
//				else
//					label.setIcon(null);
			}
		});
		
		JMenuItem exitItem = new JMenuItem("exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				System.exit(0);;
			}
		});
	}
}
