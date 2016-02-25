package com.charpter14.conceptOfThread;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {
	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private double x = 0;
	private double y = 0;
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	private double dx = 1;
	private double dy = 1;

	/**
	 * Moves the ball to the next position, reversing direction if it hits one of the edges
	 * @param bounds
	 */
	public void move(Rectangle2D bounds)
	{
		x += dx;
		y += dy;
		
		if(x < bounds.getMinX())
		{
			x = bounds.getMinX();
			dx = -dx;
		}
		if(x+XSIZE >= bounds.getMaxX())
		{
			x = bounds.getMaxX() - XSIZE;
			dx = -dx;
		}
		
		if(y < bounds.getMinY())
		{
			y = bounds.getMinY();
			dy = -dy;
		}
		
		if(y+YSIZE >= bounds.getMaxY())
		{
			y = bounds.getMaxY() - YSIZE;
			dy = -dy;
		}
	}
	
	/**
	 * get the shape of the ball at its current position
	 * 根据球的当前位置绘制球的图形
	 * @return
	 */
	public Ellipse2D getShape()
	{
		return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
	}
}
