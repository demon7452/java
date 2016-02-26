package com.charpter14.conceptOfThread;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class BounceThread {

	public static void main(String[] args) {
		//创建一个线程并运行
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new BounceFrame2();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

/**
 * A runnable that animates a bouncing ball
 * @author dev3
 *
 */
class BallRunnable implements Runnable 
{
	private Ball ball;
	private Component component;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;
	
	public BallRunnable(Ball ball,Component component) {
		this.ball = ball;
		this.component = component;
	}
	
	@Override
	public void run() {
		try {
			for(int i = 0; i <= STEPS; i++)
			{
				ball.move(component.getBounds());
				component.repaint();
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {
		}
	}
	
}

class BounceFrame2 extends JFrame
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
	private int count = 1;
	public BounceFrame2()
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
		
		addButton(buttonPanel, "thread", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(Thread.currentThread().getName());
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
		Ball ball = new Ball(ballComponent.getBounds());
		ballComponent.add(ball);
		Runnable runnable = new BallRunnable(ball,ballComponent);
		Thread thread = new Thread(runnable);
		thread.setName("thread_"+count);
		count++;
		thread.start();
	}
	
}
