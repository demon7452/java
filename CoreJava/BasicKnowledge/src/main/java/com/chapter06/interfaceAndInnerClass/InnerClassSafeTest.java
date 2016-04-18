package com.chapter06.interfaceAndInnerClass;
import com.chapter05.abstractClass.ReflectionTest;
/**
 * 内部类安全性测试
 * @author demon7452
 *
 */
public class InnerClassSafeTest {
	public static void main(String[] args){
		String className = TalkingClock.TimePrinter.class.getName();
		ReflectionTest.printClass(className);
		ReflectionTest.printClass(TalkingClock.class.getName());
	}
}
