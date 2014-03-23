public class TestGetClass
{
	public static void main(String[] args)
	{
		lixiong.Circle obj=new lixiong.Circle();
		Class metaObject=obj.getClass();
		System.out.println("object obj's class is "+metaObject.getName());
	}
}

