package com.charpter6.interfaceAndInnerClass;
import java.util.Date;
import java.util.GregorianCalendar;
public class CloneTest {

	public static void main(String[] args) {
		Date date = new Date();
		NoClone noA = new NoClone("noA",date);
		System.out.println("name:"+noA.getName()+"  calendar:"+noA.getDate().getTime());
		
		try {
			NoClone noB = noA.clone();
			noB.setName("noB");
			noB.setDate(new Date(10000000));
			System.out.println("name:"+noA.getName()+"  calendar:"+noA.getDate().getTime());
			System.out.println("name:"+noB.getName()+"  calendar:"+noB.getDate().getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
class NoClone implements Cloneable{
	private String name;
	private Date date;
	public NoClone(String name,Date date){
		this.name = name;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * 浅拷贝
	 */
	public NoClone clone() throws CloneNotSupportedException{
		return (NoClone)super.clone();
	}
}

class HaveClone implements Cloneable{
	private String name;
	private GregorianCalendar calendar;
	public HaveClone(String name,GregorianCalendar calendar){
		this.name = name;
		this.calendar = calendar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GregorianCalendar getCalendar() {
		return calendar;
	}
	public void setCalendar(GregorianCalendar calendar) {
		this.calendar = calendar;
	}
	
	/**
	 * 深拷贝
	 */
	public HaveClone clone() throws CloneNotSupportedException{
		HaveClone cloned = (HaveClone)super.clone();
		cloned.calendar = (GregorianCalendar)calendar.clone();
		return cloned;
	}
}