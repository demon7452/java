public class TestContinue
{
	public static void main(String [] args)
	{
		int sum=0;
		int number=0;
		while(number<20)
		{
			number++;
			if(number==10||number==11)continue;
			sum+=number;
			
		}
		System.out.println("the number is "+number+"\nthe sum is "+sum);
		int sum2=0;
		int number2=0;
		for(;number2<20;number2++)
		{
			if(sum2>=100)continue;
			sum2+=number2;
			
		}
		System.out.println("the number2 is "+number2+"\nthe sum2 is "+sum2);
	}
}