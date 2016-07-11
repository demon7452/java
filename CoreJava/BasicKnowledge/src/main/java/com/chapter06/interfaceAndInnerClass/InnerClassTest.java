package com.chapter06.interfaceAndInnerClass;

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
		TalkingClock.start(2000, true);
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
//		Timer timer = new Timer(interval, this.new TimePrinter());
		timer.start();
	}
	
	public class TimePrinter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Date date = new Date();
			//内部类可以直接调用外部类的实例域。
			System.out.println("your interval is "+ interval +" now time is " + date);
//			if(isBeep)
			if(TalkingClock.this.isBeep)
				Toolkit.getDefaultToolkit().beep();
		}
	}
	/**
	 * 局部类测试
	 * @param interval
	 * @param isBeep
	 */
	public static void start(final int interval,final boolean isBeep){
		class TimePrinter2 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				System.out.println(" now time is " +interval+ date);
				//局部类的方法只能引用声明为final的局部变量 ??
				if(isBeep)
					Toolkit.getDefaultToolkit().beep();
			}
		}
		ActionListener listener = new TimePrinter2();
		Timer timer = new Timer(interval, listener);
		timer.start();
	}
}
