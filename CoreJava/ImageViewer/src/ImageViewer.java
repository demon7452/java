import java.awt.EventQueue;
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
/**
 * A program for viewing images
 * @version 2014-8-19
 * @author demon7452
 */
public class ImageViewer
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new ImageViewerFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
/**
 * A frame with a label to show a image 
 */
class ImageViewerFrame extends JFrame
{
	private JLabel jlabel;
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	
	
	public ImageViewerFrame()
	{
		setTitle("ImageViewer");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
//		use the label to display the images
		jlabel = new JLabel();
		add(jlabel);
		
//		set up the file chooser
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		
//		set up the menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
//		set up menu "File"
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
//		set up menu item "Open"
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
//		add listener to item "Open"
		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
//				show file chooser dialog
				int result = chooser.showOpenDialog(null);
				
//				if file selected, set it as icon of the label
				if(result == JFileChooser.APPROVE_OPTION)
				{
					String name = chooser.getSelectedFile().getPath();
					jlabel.setIcon(new ImageIcon(name));
				}
			}
		});
		
//		set up menu item "exit"
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
//		add listener to item "exit"
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		
	}
}