package com.chapter05.abstractClass;

import java.lang.reflect.Method;
/**
 * ����ָ�����
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
			Method squareMethod = MethodPointerTest.class.getMethod("square", double.class);//��ȡ�ķ�����������Ϊpublic
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
