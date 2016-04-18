package com.chapter05.abstractClass;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * ������ʱʹ�÷����������
 * @author demon7452
 *
 */
public class ObjectAnalyzerTest {

	public static void main(String[] args) {
		Employee employee = new Employee("demon");
		employee.setSex("man");
		System.out.println(new ObjectAnalyzer().toString(employee));
	}
	private static class ObjectAnalyzer{
		private ArrayList<Object> visited = new ArrayList<Object>();
		public String toString(Object object){
			if(null == object)
				return "null";
			if(visited.contains(object))
				return "...";
			visited.add(object);
			Class class1 = object.getClass();
			if(String.class == class1)
				return (String)object;
			if(class1.isArray()){
				String resultString = class1.getComponentType()+"[]{";
				for(int i=0; i< Array.getLength(object);i++){
					if(i>0)
						resultString += ",";
					Object val = Array.get(object, i);
					if(class1.getComponentType().isPrimitive())
						resultString += val;
					else
						resultString += toString(val);
				}
				return resultString + "}";
			}
			
			String resultString = class1.getName();
			do {
				
				Field[] fields = class1.getDeclaredFields();
				class1 = class1.getSuperclass();
				if(fields.length == 0)
					continue;
				resultString += "[";
				AccessibleObject.setAccessible(fields, true);
				for(Field field : fields){
					if(!Modifier.isStatic(field.getModifiers())){
						if(!resultString.endsWith("["))
							resultString += ",";
						resultString += field.getName() + "=";
						try {
							Object value = field.get(object);
							if(field.getType().isPrimitive())
								resultString += value;
							else {
								resultString += toString(value);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				resultString += "]";
			} while (null != class1);
			return resultString;
		}
	}
}