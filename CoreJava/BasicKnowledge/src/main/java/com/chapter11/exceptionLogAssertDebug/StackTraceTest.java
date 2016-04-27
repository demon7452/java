package com.chapter11.exceptionLogAssertDebug;

import java.util.Scanner;
/**
 * 堆栈跟踪
 * @author demon7452
 * 
 *
 */
public class StackTraceTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number:");
		int number  = scanner.nextInt();
		System.out.println("\nresult:"+factorial(number));
		scanner.close();
	}

	/**
	 * 递归阶乘
	 * @param n
	 * @return
	 */
	public static int factorial(int n){
		System.out.println("factorial("+n+"):");
		Throwable throwable = new Throwable();
		StackTraceElement[] elements = throwable.getStackTrace();
		for(StackTraceElement element : elements)
			System.out.println(element);
		int result;
		if(n <= 1)
			result = 1;
		else {
			result = n * factorial(n-1);
		}
		System.out.print(n + " * " );
		return result;
	}
}
