package com.charpter6.interfaceAndInnerClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.charpter5.abstractClass.Student;

/**
 * 排序接口测试
 * @author demon7452
 *
 */
public class InterfaceTest {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("a", 1));
		students.add(new Student("b", 3));
		students.add(new Student("d", 2));
		students.add(new Student("f", 2));
		students.add(new Student("c", 4));
		printList(students);
		Collections.sort(students);
		printList(students);

	}
	private static void printList(List<Student> students){
		for(Student student:students){
			System.out.println("id:"+student.getStudentId()+" name:"+student.getName());
		}
	}

}
