import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * class TextFileTest
 * @author Administrator
 * @version 2014-9-10
 */
public class RandomFileTest
{
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args)
	{
		EmployeeRandom[] staff = new EmployeeRandom[3];
		staff[0] = new EmployeeRandom("first",5000,2014,7,10);
		staff[1] = new EmployeeRandom("second",5000,2014,8,10);
		staff[2] = new EmployeeRandom("third",5000,2014,9,10);
		
		try
		{
			//save all employee recordes to the file employee.dat
			DataOutputStream out = new DataOutputStream(new FileOutputStream("employee2.dat"));
			for(EmployeeRandom employeeRandom : staff)
				employeeRandom.writeData(out);
			out.close();
			
			
			//retrieve all records into a new array
			RandomAccessFile in = new RandomAccessFile("employee2.dat","rw");
			//compute the array size
			int n = (int)(in.length() / EmployeeRandom.RECORD_SIZE);
			EmployeeRandom[] newStaff = new EmployeeRandom[n];
			
			//read employees in reverse order
			for(int i = n-1; i >= 0; i--)
			{
				newStaff[i] = new EmployeeRandom();
				in.seek(i * EmployeeRandom.RECORD_SIZE);
				newStaff[i].readData(in);
			}
			in.close();
			
			//print the newly read employee records
			for(EmployeeRandom e : newStaff)
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
 * class EmployeeRandom
 * @author demon7452
 *@version 2014-9-10
 */
class EmployeeRandom
{
	private String name;
	private double salary;
	private Date hireDay;
	
	/**
	 * static final int 
	 */
	public static final int NAME_SIZE = 40;
	public static final int RECORD_SIZE = NAME_SIZE * 2 + 8 + 4 + 4 + 4;
	
	public EmployeeRandom()
	{
	}
	
	public EmployeeRandom(String name, double salary, int year, int month, int day)
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
	public void writeData(DataOutput out)throws IOException
	{
		DataIO.writeFixedString(name, NAME_SIZE, out);
		out.writeDouble(salary);
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(hireDay);
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH) + 1);
		out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * Reads employee data from a buffererd reader
	 * @param in the scanner
	 */
	public void readData(DataInput in)throws IOException
	{
		
		name = DataIO.readFixedString(NAME_SIZE, in);//in.skipBytes() 出错；
		salary = in.readDouble();
		int year = in.readInt();   //出错了，为什么？
		int month = in.readInt();
		int day = in.readInt();
		GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
		hireDay = calendar.getTime();
	}
}
class DataIO
{
	/**
	 * 从输入流中读入字符
	 * @param size 多少个码元
	 * @param in
	 * @return 字符串
	 * @throws IOException
	 */
	public static String readFixedString(int size, DataInput in)throws IOException
	{
		StringBuilder b = new StringBuilder(size);
		int i = 0;
		boolean more = true;
		while(more && i < size)
		{
			char ch = in.readChar();
			i++;
			if(ch == 0 )
				more = false;//到达末尾，跳出
			else 
				b.append(ch);
		}
		in.skipBytes(2 *size -2*i);//一个字符占两个字节，跳过字符串空间剩下的字节
		return b.toString();
	}
	
	/**
	 * 写出从字符串开头开始的指定数量的码元，码元过少用0补齐字符串！
	 * @param s
	 * @param size
	 * @param out
	 * @throws IOException
	 */
	public static void writeFixedString(String s, int size, DataOutput out)throws IOException
	{
		for(int i =0; i < size; i++)
		{
			char ch = 0;
			if(i < s.length())
				ch = s.charAt(i);
			out.writeChar(ch);
		}
	}
}



















