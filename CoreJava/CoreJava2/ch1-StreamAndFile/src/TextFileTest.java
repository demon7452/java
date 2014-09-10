import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

/**
 * class TextFileTest
 * @author Administrator
 * @version 2014-9-10
 */
public class TextFileTest
{
	/**
	 * writes all employees in an array to a print writer
	 * @param employees an array of employees
	 * @param out a print writer
	 * @throws IOException
	 */
	private static void writeData(Employee[] employees, PrintWriter out)throws IOException
	{
		//write number of employees
		out.println(employees.length);
	
		//erfodic array 遍历数组
		for(Employee e : employees)
		{
			e.writeData(out);
		}
	}
	
	/**
	 * Reads an array of employees from a scanner
	 * @param in the scanner
	 * @return the array of employees
	 */
	private static Employee[] readData(Scanner in)
	{
		int  n = in.nextInt();//retrieve the array size
		in.nextLine();//consume newline
		
		Employee[] employees = new Employee[n];
		for(int i = 0; i < n; i++)
		{
			employees[i] = new Employee();
			employees[i].readData(in);
		}
		return employees;
	}
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args)
	{
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("first",5000,2014,7,10);
		staff[1] = new Employee("second",5000,2014,8,10);
		staff[2] = new Employee("third",5000,2014,9,10);
		
		try
		{
			//PrintWriter向文件输出内容，Scanner从文件读取内容！
			PrintWriter outTest = new PrintWriter("test.dat");
			outTest.println("hello world");
			outTest.close();
			Scanner inTest = new Scanner(new FileReader("test.dat"));
			String testString = inTest.nextLine();
			System.out.println(testString);
			
			//save all employee recordes to the file employee.dat
			PrintWriter out = new PrintWriter(new FileWriter("employee.dat"),true);
			writeData(staff, out);
			out.close();
			
			//retrieve all records into a new array
			Scanner in = new Scanner(new FileReader("employee.dat"));
			Employee[] newStaff = readData(in);
			in.close();
			
			//print the newly read employee records
			for(Employee e : newStaff)
			{
				System.out.println(e);
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}

/**
 * class Employee
 * @author demon7452
 *@version 2014-9-10
 */
class Employee
{
	private String name;
	private double salary;
	private Date hireDay;
	public Employee()
	{
	}
	
	public Employee(String name, double salary, int year, int month, int day)
	{
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year, month -1,day);
		this.hireDay = calendar.getTime();
	}
	
	public String getName()
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
		double raise = salary  *  byPercent / 100;
		salary = salary + raise;
	}
	
	public String toString()
	{
		return getClass().getName() + "[name="+name+",salary="+salary+",hireDay="+hireDay+"]";
	}
	
	/**
	 * Writes employee data to a print writer
	 * @param out the print writer
	 */
	public void writeData(PrintWriter out)
	{
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(hireDay);
		out.println(name+"|"+salary+"|"+calendar.get(Calendar.YEAR)+"|"+(calendar.get(Calendar.MONTH)+1)+"|"+calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * Reads employee data from a buffererd reader
	 * @param in the scanner
	 */
	public void readData(Scanner in)
	{
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
		name = tokens[0];
		salary = Double.parseDouble(tokens[1]);
		int year =  Integer.parseInt(tokens[2]);
		int month = Integer.parseInt(tokens[3]);
		int day = Integer.parseInt(tokens[4]);
		GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
		hireDay = calendar.getTime();
	}

}