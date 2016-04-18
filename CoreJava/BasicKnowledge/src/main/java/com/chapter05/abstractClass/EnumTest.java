package com.chapter05.abstractClass;
public class EnumTest {

	public static void main(String[] args) {
		System.out.println(Size.LARGE);
		System.out.println(Size.LARGE.toString());
		Size size = Enum.valueOf(Size.class,"MEDIUM");//���ܻ��׳��쳣
		System.out.println(size.toString());
		
		System.out.println(Size2.LARGE.getDesc());
		System.out.println(Size2.getSize2("MEDIUM"));
		System.out.println(Size2.getSize2("MEDIUM2"));
		System.out.println(Size2.getSize2(null));
		System.out.println(Size2.getEnum("��"));
		System.out.println(Size2.getEnum("��2"));
		System.out.println(Size2.getEnum(null));
		try {
			Enum.valueOf(Size.class, "test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
enum Size{
//	LARGE("��"),MEDIUM("��"),SMALL("С");
	LARGE,MEDIUM,SMALL;
}

enum Size2{
	LARGE("��"),MEDIUM("��"),SMALL("С");
	private String desc;
	private Size2(String desc){
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public static Size2 getSize2(String enumName){
		Size2 size2 = null;
		try {
			size2 = Enum.valueOf(Size2.class, enumName);
		}
		catch (NullPointerException e) {
			System.out.println("desc is null");
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return size2;
	}
	public static Size2 getEnum(String desc){
		if(null == desc)
			return null;
		switch (desc) {
		case "��":
			return LARGE;
		case "��":
			return MEDIUM;
		case "С":
			return SMALL;
		default:
			return null;
		}
		
	}
}