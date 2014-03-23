public class TestString
{
	public static void main(String[] args)
	{
		String message=new String("welcome to java");
		char[] charArray={'g','o','o','d',' ','d','a','y'};
		String arrayMessage=new String(charArray);
		String s="   welcome to java    ";
		String s1=s.intern();
		String message2=new String("welcome to java");

 /**System.out.println(message);
		System.out.println(arrayMessage);
		System.out.println(s);
		System.out.println(s.equals(message));
		System.out.println(s==message);
		System.out.println(s.intern()==message.intern());
		System.out.println(s==s1);
		System.out.println(message2==message);*/

	
		String S="WELCOME TO JAVA";				
		System.out.println(s.equalsIgnoreCase(S));
		System.out.println(s.trim());
		System.out.println(s);

	}
}

