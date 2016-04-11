package com.charpter4.objectAndClass;

public class StaticClass {

	public static void main(String[] args) {
		System.out.println(Static.classId);
		Static static1 = new Static();
		static1.addClassId(2);
		System.out.println(Static.classId);
		
		System.out.println(Static.finalId);
		Static.addFinalId(2);
		System.out.println(Static.finalId);
	}

}
class Static{
	public static int classId = 1;
	public final static int finalId = 1;
	
	public void addClassId(int num){
		classId += num;
	}
	
	public static void addFinalId(int num){
		setFinalId(num);
	}
	private native static void setFinalId(int num);
}