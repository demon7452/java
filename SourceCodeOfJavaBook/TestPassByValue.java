public class TestPassByValue
{
	public static void main(String[] args)
	{
		int num1=1;
		int num2=2;
		System.out.println("before invoking the swap method,num1 is "+num1+" num2 is "+num2);
		swap(num1,num2);
		System.out.println("after invoking the swap method,num1 is "+num1+" num2 is "+num2);
  }
	public static void swap(int n1,int n2)
	{
  	System.out.println("before invoking the swap method,n1 is "+n1+" n2 is "+n2);
    int temp=n1;
		n1=n2;
		n2=temp;
  	System.out.println("after invoking the swap method,n1 is "+n1+" n2 is "+n2);
	}
}
