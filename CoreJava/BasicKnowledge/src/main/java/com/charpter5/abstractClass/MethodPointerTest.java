package com.charpter5.abstractClass;

import java.lang.reflect.Method;
/**
 * 方法指针测试
 * @author admin
 *
 */
public class MethodPointerTest {

	public static void main(String[] args) {
		try {
			Employee employee = new Employee("hello");
			Method getName = Employee.class.getMethod("getName");
			Method setName = Employee.class.getMethod("setName", String.class);
			String name = (String)getName.invoke(employee);
			System.out.println(name);
			setName.invoke(employee, "world");
			System.out.println(getName.invoke(employee));
			
			double num = 11;
			Method squareMethod = MethodPointerTest.class.getMethod("square", double.class);//获取的方法必须声明为public
			System.out.println(squareMethod.invoke(null, num));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static double square(double num){
		return num * num;
	}

}
