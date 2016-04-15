package com.charpter6.interfaceAndInnerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 * 回调测试
 * 指出特定事件发生时应该采取的动作
 * @author admin
 *
 */
public class TimerTest {

	public static void main(String[] args) {
		int result = JOptionPane.showConfirmDialog(null, "是否启动定时器？");
		if(JOptionPane.YES_OPTION == result){
			Timer timer = new Timer(2000, new TimePrinter());
			timer.start();
			JOptionPane.showMessageDialog(null, "exit program");
			System.exit(0);
		}else {
			if(JOptionPane.NO_OPTION == result)
				System.out.println("your choice is NO");
			if(JOptionPane.CANCEL_OPTION == result)
				System.out.println("your choice is CANCEL");
			System.out.println(result+"gg 思密达！！");
		}

	}
}
class TimePrinter implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Date date = new Date();
		System.out.println("now time is " + date);
		Toolkit.getDefaultToolkit().beep();//发出声音
	}
	
}