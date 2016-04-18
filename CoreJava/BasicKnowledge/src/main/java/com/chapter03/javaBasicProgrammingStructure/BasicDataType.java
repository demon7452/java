package com.chapter03.javaBasicProgrammingStructure;

import java.io.Console;
import java.util.Scanner;

import org.junit.Test;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * java 基本的程序设计结构，基本数据类型
 * @author xiong.li
 *
 */
public class BasicDataType
{

	public static final double PI = 3.1415926;
	public static void main(String[] args)
	{
		char a = 'b';
		int x = a;
		System.out.println(x);

	}
	
	@Test
	public void testFinalVariable()
	{
		System.out.println(PI);
		final String out = "测试常量";
		System.out.println(out);
		System.out.println(Math.PI);
	}
	
	@Test
	public void typeConvert()
	{
		char charCharacter = 'A';
		int charNum = charCharacter;
		
		byte byteNum = 1;
		short shortNum = byteNum;
		int intNum = shortNum;
		long longNum = intNum;
		
		//强制转换
		double doubleNum = 2.50;
		int doubleToInt = (int)doubleNum;
		
		//四舍五入
		int roundInt = (int)Math.round(doubleNum);
		System.out.println(""+doubleToInt+ "   "+roundInt);
	}
	
	@Test
	public void testEnum()
	{
		Size small = Size.SMALL;
	}
	
	@Test
	public void testString()
	{
		System.out.println("HELlo".equalsIgnoreCase("hello")?"yes":"no");
		System.out.println("hello".endsWith("lol")?"yes":"no");
		System.out.println("hello".startsWith("he")?"yes":"no");
		System.out.println("hello".replace('l', 'm'));
	}
	
	@Test
	public void testStringBuilder()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("hello");
		System.out.println(builder.toString());
		builder.append(" world");
		System.out.println(builder.toString());
		builder.insert(5, "SB");
		System.out.println(builder.toString());
	}
	
	@Test
	public void testInlput()
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("what is your name?");
		String name = scanner.nextLine();
		
		System.out.println("How old are you?");
		int age = scanner.nextInt();
		
		System.out.println("your name is "+name +"! your age is "+age);
	}
	
	@Test
	public void testPassword()
	{
		Console console = System.console();
		
		String name = console.readLine("your name:","%s");
		char[] password = console.readPassword("your password:","%s");
		
//		System.out.println("your name is "+name + "your passwod is " + password.toString());
	}
	
	@Test
	public void testFormatOutput()
	{
		System.out.printf("hello %s! your age is %d.","world",12);
		System.out.println();
		System.out.printf("%,d",1000000100);
		System.out.println();
		System.out.printf("%,.4f",10000.0/3.0);
	}
}
