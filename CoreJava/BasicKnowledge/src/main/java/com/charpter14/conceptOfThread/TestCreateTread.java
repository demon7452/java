package com.charpter14.conceptOfThread;

/**
 * 创建线程的两种方式
 * @author dev3
 *
 */
public class TestCreateTread 
{
	public static void main(String[] args)
	{
		MyRunnable one = new MyRunnable("one");
		Thread thread1 = new Thread(one);
		
		MyRunnable two = new MyRunnable("two");
		Thread thread2 = new Thread(two);
		
		thread2.start();
		thread1.start();
		
//		Thread three = new MyThread("three");
//		Thread four = new MyThread("four");
//		three.start();
//		four.start();
	}
}

class MyRunnable implements Runnable
{
	private String name;
	public MyRunnable(String name) 
	{
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println("excute runnable " + this.name);
	}
	
}

class MyThread extends Thread
{
	private String name;
	public MyThread(String name)
	{
		this.name = name;
	}
	
	@Override
	public void run()
	{
		System.out.println("excute thread " + this.name);
	}
}
