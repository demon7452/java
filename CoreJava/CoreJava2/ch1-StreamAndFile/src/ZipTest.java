import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 * test zip file
 * @author demon7452
 * @version 2014-9-11
 */
public class ZipTest
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				// TODO Auto-generated method stub
				ZipTestFrame frame = new ZipTestFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
/**
 * A frame with a text area to show the contents of a file inside a ZIP archive, a combo 
 * box to select different files in the archive, and a menu to load a new archive
 * @author demon7452
 * @version 2014-9-11
 */
class ZipTestFrame extends JFrame
{

	/**
	 * static final int width and height
	 */
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 300;
	
	private JComboBox jcbFile;
	private JTextArea jtaFile;
	private String zipname;
	
	/**
	 * Construction method
	 */
	public ZipTestFrame()
	{
		setTitle("ZipTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		//add the menu and the open and exit menu items
		JMenuBar menuBar = new JMenuBar(); //菜单栏
		JMenu jmFile = new JMenu("File"); //菜单项File
		
		JMenuItem jmiOpen = new JMenuItem("Open");//下拉选项 open
		JMenuItem jmiExit = new JMenuItem("Exit");//下拉选项 exit
		jmFile.add(jmiOpen);
		jmFile.add(jmiExit);
		menuBar.add(jmFile);
		
		//add listener to Open item and exit item
		jmiOpen.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("."));
				int r = chooser.showOpenDialog(ZipTestFrame.this);
				if(r == JFileChooser.APPROVE_OPTION)
				{
					zipname = chooser.getSelectedFile().getPath();
					jcbFile.removeAllItems();
					scanZipFile();
					System.out.println(zipname);
				}
			}
		});
		
		jmiExit.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				System.exit(0);//exit
			}
		});
		setJMenuBar(menuBar);//添加菜单栏
		
		//add the text area and combo box
		jtaFile = new JTextArea();
		jcbFile = new JComboBox();
		
		jcbFile.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				loadZipFile((String)jcbFile.getSelectedItem());
			}
		});
		add(new JScrollPane(jtaFile),BorderLayout.CENTER);
		add(jcbFile,BorderLayout.SOUTH);
	}
	/*
	 * Scans the contents of the zip archive and populates the combo box
	 */
	public void scanZipFile()
	{
		new SwingWorker<Void, String>()
		{
			protected Void doInBackground()throws Exception
			{
					System.out.println(zipname);
				ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
				ZipEntry entry;
				System.out.println("test");
				while((entry = zin.getNextEntry()) != null)
				{
					System.out.println("test");
					publish(entry.getName());
					zin.closeEntry();
				}
				zin.close();
				return null;
			}
			
			protected void process(List<String> names)
			{
				for(String nameString : names)
				{
					System.out.println(nameString);
					jcbFile.addItem(nameString);
				}
			}
		}.execute();
	}
	
	/**
	 * loads a file from the zip archive into the text area
	 * @param name the name of the file in the archive
	 */
	public void loadZipFile(final String name)
	{
		jcbFile.setEnabled(false);
		jtaFile.setText("");
		
							System.out.println("test");
		new SwingWorker<Void, Void>()
		{
			protected Void doInBackground()throws Exception
			{
				try
				{
					ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
					ZipEntry entry;
					
							System.out.println("test");
					//find entry with matching name archive
					while((entry = zin.getNextEntry()) != null)
					{
						if(entry.getName().equals(name))
						{
							System.out.println("test");
							//read entry into text area
							Scanner in = new Scanner(zin);
							while(in.hasNextLine())
							{
								jtaFile.append(in.nextLine());
								jtaFile.append("\n");
							}
						}
						zin.closeEntry();
					}
					zin.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				return null;
			}
			
			protected void done()
			{
				jcbFile.setEnabled(true);
			}
		}.execute();
	}
	
}