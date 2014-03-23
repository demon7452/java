import java.util.*;
public class Employee
{
	public Employee(String n,double s,int year,int month,int day)
	{
		name=n;
		salary=s;
		GregorianCalendar calendar=new GregorianCalendar(year,month-1,day);
		hireDay=calendar.getTime();
	}
	public String getname()
	{
		return name;

	}
	public double getSalary()
	{
		return salary;
	}
	public Date getHireday()
	{
		return hireDay;
	}
	public void raiseSalary(double byPercent)
	{
		 salary=salary*(1+byPercent/100);
	}
	private String name;
	private double salary;
	private Date hireDay;
}

