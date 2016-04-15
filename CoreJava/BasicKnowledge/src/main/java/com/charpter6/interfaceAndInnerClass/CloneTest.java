package com.charpter6.interfaceAndInnerClass;
import java.util.Date;
public class CloneTest {

	public static void main(String[] args) {
		//浅拷贝测试
		Date date = new Date();
		Description description = new Description("this is a clone test!");
		NoClone noA = new NoClone("noA",date,description);
		System.out.println("name:"+noA.getName()+"  calendar:"+noA.getDate().getTime() + " Description:"+noA.getDescription().getDescription());
		try {
			NoClone noB = noA.clone();
			noB.setName("noB");
			noB.setDate(new Date(10000000));
			noB.getDescription().setDescription("hello world!!");
			System.out.println("name:"+noA.getName()+"  calendar:"+noA.getDate().getTime()+" Description:"+noA.getDescription().getDescription());
			System.out.println("name:"+noB.getName()+"  calendar:"+noB.getDate().getTime()+" Description:"+noB.getDescription().getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//深拷贝测试
		try {
			DeepClone deepCloneA = new DeepClone("deepA", new Description("deep clone"));
			System.out.println("Name:"+deepCloneA.getName()+" Description:"+deepCloneA.getDescription().getDescription());
			DeepClone deepCloneB = deepCloneA.clone();
			deepCloneB.setName("deepB");
			deepCloneB.getDescription().setDescription("hello hahaha");
			System.out.println("Name:"+deepCloneA.getName()+" Description:"+deepCloneA.getDescription().getDescription());
			System.out.println("Name:"+deepCloneB.getName()+" Description:"+deepCloneB.getDescription().getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
class NoClone implements Cloneable{
	private String name;
	private Date date;
	private Description description;
	public NoClone(String name,Date date,Description description){
		this.name = name;
		this.date = date;
		this.description = description;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
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

class DeepClone implements Cloneable{
	private String name;
	private Date date;
	private Description description;
	public DeepClone(String name,Description description){
		this.name = name;
		this.description = description;
	}
	public DeepClone(String name,Date date,Description description){
		this.name = name;
		this.date = date;
		this.description = description;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
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
	 * 
	 * 深拷贝
	 */
	public DeepClone clone() throws CloneNotSupportedException{
		DeepClone cloned = (DeepClone)super.clone();
//		cloned.date = (Date)date.clone();
		cloned.description = (Description)description.clone();
		return cloned;
	}
}

class Description implements Cloneable{
	private String description;
	public Description(String description){
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Description clone() throws CloneNotSupportedException{
		return (Description)super.clone();
	}
}