package com.charpter4.objectAndClass;

import java.util.Random;
/**
 *                                 _oo0oo_
 *                                o8888888o
 *                                88" . "88
 *                                (/ -_- /)
 *                                0\  =  /0
 *                               __/'---'\__ 
 *                             .' \\/    |//'.
 *                            / \\/// :  |||/ \
 *                           / _//// -:- ////- \
 *                          /   / \\\ -  /// \  \
 *                         |  \_/ ''\---/''  /_/ |
 *                         \   '-\__ '_' __/-'   /
 *                      ____'. .'  /--.--\  '. .'____
 *                   .""  '<  `.___\_</>_/___.'  >'  "".      
 * 		            /  / :  '- \'.;'\ _ /';.'/ -'  : \  \
 * 	                \  \  `_.   \_ __\/__ _/    ._'  /  /
 * 	            =====`-.____ .___  \____/   ___. ____.-'=====
 *                                 '=---=' 			
 * 
 *         ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *                     
 *                            ·ð×æ±£ÓÓ              ÓÀÎÞBug
 */
public class ConstructorTest {

	public static void main(String[] args) {
		Employee employee1 = new Employee("hello");
		System.out.println(employee1.getName()+employee1.getId());
		Employee employee2 = new Employee("world");
		System.out.println(employee2.getName()+employee2.getId());
	}

}
class Employee{
	private static int nextId;
	private int id;
	private String name;
	
	static{
		nextId = new Random().nextInt(100);
	}
	{
		id = nextId;
		nextId++;
	}
	public Employee(String name){
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
