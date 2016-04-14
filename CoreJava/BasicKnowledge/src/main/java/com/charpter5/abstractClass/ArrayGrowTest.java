package com.charpter5.abstractClass;

import java.lang.reflect.Array;

/**
 * 使用反射编写泛型数组
 * @author admin
 *
 */
public class ArrayGrowTest {

	public static void main(String[] args) {
		int[] array1={1,2,3,4,5,6};
		printArray(array1);
		array1 =(int[])goodArrayGrow(array1);
		printArray(array1);
		
		String[] array2 = {"a","b","c"};
		printArray(array2);
		array2 = (String[])goodArrayGrow(array2);
		printArray(array2);

		array2 = (String[])badArrayGrow(array2);
		
	}
	
	private static Object[] badArrayGrow(Object[] array){
		int newLength = array.length * 11 / 10 +10;
		Object[] newArray = new Object[newLength]; //返回的newArray，其类型为Object 不能转换成其他类型
		System.arraycopy(array, 0, newArray, 0, array.length);
		return newArray;
	}
	
	private static Object goodArrayGrow(Object array){
		Class class1 = array.getClass();
		if(!class1.isArray())
			return null;
		int length = Array.getLength(array);
		int newLength = length * 11 / 10 + 10;
		Object newArray = Array.newInstance(class1.getComponentType(), newLength);
		System.arraycopy(array, 0, newArray, 0, length);
		return newArray;
	}
	
	private static void printArray(Object array){
		Class class1 = array.getClass();
		if(!class1.isArray()){
			System.out.println(class1.getName() + " is not a array");
			return;
		}
		
		int length = Array.getLength(array);
		System.out.print(class1.getComponentType().getName() + "["+length+"]={");
		for(int i=0; i<length; i++){
			if(i>0)
				System.out.print(",");
			System.out.print(Array.get(array, i));
		}
		System.out.println("}");
	}
	
}
