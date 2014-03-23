public class PolymorphismDemo
{
	public static void main(String[] args)
	{
		Student a=new GraduateStudent();
		p(a);
		m(new GraduateStudent());
		m(new Student());
		m(new Person());
		m(new Object());
	}
	public static void p(Student x)
	{
			x.max();
	}
	public static void m(Object x)
	{
		System.out.println(x.toString());
	}
}
class GraduateStudent extends Student
{
	public void max()
	{
		System.out.println("max");
	}
}
class Student extends Person
{
	public void max()
	{
		System.out.println("min");
	}
	public String toString()
	{
		return "student";
	}
}
class Person extends Object
{
	/**public String toString()
	{
		return "person";
	}*/
}
