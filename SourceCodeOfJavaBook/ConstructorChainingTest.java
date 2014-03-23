public class ConstructorChainingTest extends Employee
{
	public static void main(String[] args)
	{
		new ConstructorChainingTest();
	}
	public ConstructorChainingTest()
	{
		System.out.println("4 constructor chaining test");
	}
}
class Employee extends Person
{
	public Employee()
	{
		this("2 employee's");
		System.out.println("3 employee's");
	}
	public Employee(String s)
	{
		System.out.println(s);
	}
}
class Person
{
	public Person()
	{
		System.out.println("1 person's ");
	}
}
