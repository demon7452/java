package com.charpter14.conceptOfThread;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BallComponent extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5954504076043051915L;
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	
	/**
	 * add a ball to the component
	 * @param ball
	 */
	public void add(Ball ball)
	{
		balls.add(ball);
	}
	
	/**
	 * 绘制图形球
	 */
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);//erase background 擦除图形
		Graphics2D graphics2d = (Graphics2D)graphics;
		for(Ball ball : balls)
		{
			graphics2d.fill(ball.getShape());
		}
		
	}
}
