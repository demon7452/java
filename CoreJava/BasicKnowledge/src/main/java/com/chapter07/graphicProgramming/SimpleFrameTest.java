package com.chapter07.graphicProgramming;

import javax.swing.JFrame;

/**
 * 简单的图形框架
 * @author admin
 *
 */
public class SimpleFrameTest {

	public static void main(String[] args) {
		JFrame frame = new SimpleFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class SimpleFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	
	public SimpleFrame(){
		setSize(WIDTH, HEIGHT);
	}
}
