package com.chapter05.abstractClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * ?????????????????
 * @author demon7452
 * 
 *
 */
public class ReflectionTest {

	public static void main(String[] args) {
		String className = Employee.class.getName();
//		className = Date.class.getName();
//		if(args.length > 0)
//			className = args[0];
//		else {
//			Scanner in = new Scanner(System.in);
//			System.out.println("enter a class name(e.g java.util.Date):");
//			className = in.next();
//			in.close();
//		}
//		System.exit(0);
		printClass(className);
	}

	public static void printClass(String className){
		System.out.println(className);
		try {
			Class class1 = Class.forName(className);
			Class superCl = class1.getSuperclass();
			String modifiers = Modifier.toString(class1.getModifiers());//???????????
			if(modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.print("class " + className);
			if(null != superCl && Object.class != superCl){
				System.out.print(" extends " + superCl.getName());
			}
			System.out.print("\n{\n");
			printFields(class1);
			System.out.println();
			printConstructors(class1);
			System.out.println();
			printMethods(class1);
			System.out.println("}");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ?????? ??
	 * @param class1
	 */
	private static void  printFields(Class class1) {
		Field [] fields = class1.getDeclaredFields();
		for(Field field : fields){
			printModifiers(field.getModifiers());
			Class type = field.getType();
			String fieldName = field.getName();
			System.out.println(" "+type.getName() + " " + fieldName + ";");
		}
	}
	
	/**
	 * ?????????
	 * @param class1
	 */
	private static void printConstructors(Class class1){
		Constructor[] constructors = class1.getDeclaredConstructors();
		for(Constructor constructor : constructors){
			printModifiers(constructor.getModifiers());
			String constructorName = constructor.getName();
			System.out.print(" " + constructorName + "(");
			printParams(constructor.getParameterTypes());
		}
	}
	
	private static void printMethods(Class class1) {
		Method[] methods = class1.getDeclaredMethods();
		for(Method method : methods){
			printModifiers(method.getModifiers());
			System.out.print(" " + method.getReturnType().getName() + " " + method.getName() + "(" );
			printParams(method.getParameterTypes());
		}
	}
	
	private static void printParams(Class[] paramTypes){
		String paramString = "";
		for(Class p:paramTypes){
			paramString += p.getName() + ",";
		}
		if(paramString.length() > 0)
			System.out.println(paramString.substring(0,paramString.length()-1)+")");
		else {
			System.out.println(")");
		}
	}
	/**
	 * ???????????
	 * @param mod
	 */
	private static void printModifiers(int mod){
		String modifier = Modifier.toString(mod);
		if(modifier.length() > 0)
			System.out.printf("%10s",modifier);
	}
}
