package com.charpter14.conceptOfThread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class TestSynchronous {
	
//	private Condition condition = myLock.newCondition();

	ExecutorService
	public static void main(String[] args)
	{

		Thread one = new Thread(new Runnable() {
			@Override
			public void run() {
				printNum(1);
			}
		});
		Thread three = new Thread(new Runnable() {
			
			@Override
			public void run() {
				printNum(3);
			}
		});
		Thread two = new Thread(new Runnable() {
			@Override
			public void run() {
				printNum(2);
			}
		});
		
		one.start();
		two.start();
		three.start();
	}
	
	public synchronized static void printNum(int num)
	{
		System.out.println(num);
	}
}



