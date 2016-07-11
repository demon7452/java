package com.chapter10.deployApplicationAndApplet;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 配置文件测试
 * @author admin
 *
 */
public class PropertiesTest {

	public static void main(String[] args) {
//		storeProPerties();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new PropertiesFrame();
				frame.setVisible(true);
			}
		});
	}	
	private static void storeProPerties(){
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
		Properties defaultProperties = new Properties();
		defaultProperties.put("left","0");
		defaultProperties.put("top","0");
		defaultProperties.put("width","300");
		defaultProperties.put("height","300");
		defaultProperties.put("title", "hello");
		File propertiesFile = new File("src/main/resources/program.properties");
		try {
			FileOutputStream outputStream = new FileOutputStream(propertiesFile);
			defaultProperties.store(outputStream, "Program Properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class PropertiesFrame extends JFrame{
	public PropertiesFrame(){
		Properties defaultProperties = new Properties();
		defaultProperties.put("left","0");
		defaultProperties.put("top","0");
		defaultProperties.put("width","300");
		defaultProperties.put("height","300");
		defaultProperties.put("title", "");
		final Properties settings = new Properties(defaultProperties);
		final File propertiesFile = new File("src/main/resources/program.properties");
		if(propertiesFile.exists()){
			try {
				FileInputStream inputStream = new FileInputStream(propertiesFile);
				settings.load(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		int left = Integer.parseInt(settings.getProperty("left"));
		int top = Integer.parseInt(settings.getProperty("top"));
		int width = Integer.parseInt(settings.getProperty("width"));
		int height = Integer.parseInt(settings.getProperty("height"));
		setBounds(left, top, width, height);
		
		String title = settings.getProperty("title");
		if("".equals(title))
			title = JOptionPane.showInputDialog("please enter a title:");
		if(null == title)
			title = "null";
		setTitle(title);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event){
				settings.put("left",getX()+"");
				settings.put("top",getY()+"");
				settings.put("width",getWidth()+"");
				settings.put("height",getHeight()+"");
				settings.put("title", getTitle());
				
				try {
					FileOutputStream outputStream = new FileOutputStream(propertiesFile);
					settings.store(outputStream, "program setting");
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
	}
}
