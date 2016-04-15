package com.charpter6.interfaceAndInnerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * 匿名内部类测试
 * @author admin
 *
 */
public class AnonymousInnerClass {

	public static void main(String[] args) {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("now time is "+ new Date());
				Toolkit.getDefaultToolkit().beep();
			}
		};
		Timer timer = new Timer(2000, listener);
		timer.start();
		JOptionPane.showMessageDialog(null, "exit program!!");
		System.exit(0);
	}
}
