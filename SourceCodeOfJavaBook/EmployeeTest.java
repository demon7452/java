import java.util.*;
import javax.swing.JOptionPane;
public class EmployeeTest
{
	public static void main(String args[])
	{
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("ѦԴ",75000,1987,12,15);
		staff[1]=new Employee("����",50000,1989,10,1);
		staff[2]=new Employee("����",40000,1988,3,15);
		for (int i=0;i<staff.length;i++)
			staff[i].raiseSalary(5);
		for (int i=0;i<staff.length;i++)
		{
			Employee e=staff[i];
			System.out.println("����"+e.getname()+"������="+e.getSalary()+"����������"+e.getHireday());
			JOptionPane.showMessageDialog(null,"����"+e.getname()+"������="+e.getSalary()+"����������"+e.getHireday());
		}
	}
}
class Employee
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

