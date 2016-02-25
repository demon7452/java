package com.charpter14.conceptOfThread;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Bounce {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new BounceFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);				
			}
		});
	}
}

class BounceFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BallComponent ballComponent;
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;
	
	private double x = 0;
	private double y = 0;
	
	public BounceFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setTitle("Bounce");
		
		ballComponent = new BallComponent();
		add(ballComponent,BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "start", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addBall();
			}
		});
		
		addButton(buttonPanel, "close", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * add a button to container
	 * bind button listener
	 * @param container
	 * @param buttonTitle
	 * @param listener
	 */
	public void addButton(Container container,String buttonTitle,ActionListener listener)
	{
		JButton button = new JButton(buttonTitle);
		container.add(button);
		button.addActionListener(listener);
	}
	
	public void addBall()
	{
		try {
			Ball ball = new Ball();
			ball.setX(x);
			ball.setY(y);
			System.out.println(ball.getX() +"   " + ball.getY());
			ballComponent.add(ball);
			for(int i = 1; i <= STEPS; i++)
			{
				ball.move(ballComponent.getBounds());
				ballComponent.paint(ballComponent.getGraphics());
				Thread.sleep(DELAY);
			}
			x = ball.getX();
			y = ball.getY();
			System.out.println(ball.getX() +"   " + ball.getY());
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
}