package com.charpter6.interfaceAndInnerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * 内部类测试
 * 使用内部类访问对象的实例域
 * @author demon7452
 *
 */
public class InnerClassTest {

	public static void main(String[] args) {
		TalkingClock talkingClock = new TalkingClock(3000,true);
		talkingClock.start();
		JOptionPane.showMessageDialog(null, "exit program?");
		System.exit(0);
	}
}
class TalkingClock{
	private int interval;
	private boolean isBeep;
	
	public TalkingClock(int interval,boolean isBeep){
		this.interval = interval;
		this.isBeep = isBeep;
	}
	
	public void start(){
		Timer timer = new Timer(interval, new TimePrinter());
		timer.start();
	}
	
	public class TimePrinter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Date date = new Date();
			//内部类可以直接调用外部类的实例域。
			System.out.println("your interval is "+ interval +" now time is " + date);
			if(isBeep)
				Toolkit.getDefaultToolkit().beep();
		}
	}
}
