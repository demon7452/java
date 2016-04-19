package com.chapter10.deployApplicationAndApplet;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ResourceTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new ResourceFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}
}
class ResourceFrame extends JFrame{
	private static final long serialVersionUID = 7084856892464656167L;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	public ResourceFrame(){
		setTitle("ResourceTest");
		setSize(WIDTH, HEIGHT);
		URL imgUrl = getClass().getResource("icon.png");
		Image image = Toolkit.getDefaultToolkit().getImage(imgUrl);
		setIconImage(image);
		
		JTextArea textArea = new JTextArea();
		InputStream inputStream = getClass().getResourceAsStream("text");
		Scanner in = new Scanner(inputStream);
		while (in.hasNext()) {
			textArea.append(in.nextLine()+"\n");
		}
		in.close();
		textArea.setEditable(false);
		add(textArea);
	}
}