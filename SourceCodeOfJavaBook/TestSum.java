public class TestSum
{
	public static void main(String[] args)
	{
		float sum1=0;
		int count1=1;
		for(float i=0.01f;i<=1.0f;i+=0.01)
		{
			System.out.println("第"+count1+"个:"+i);
			count1++;
			sum1+=i;
		}
		System.out.println("the sum1 is "+sum1);
		
		double sum2=0;
		int count2=1;
		for(double i=0.01;i<=1.0;i+=0.01)
		{
			System.out.println("第"+count2+"个:"+i);
			count2++;
			sum2+=i;
		}
		System.out.println("the sum1 is "+sum2);
		
		double sum3=0;
		int count3=1;
		for(double i=1.0;i>=0.01;i-=0.01)
		{
			System.out.println("第"+count3+"个:"+i);
			count3++;
			sum3+=i;
		}
		System.out.println("the sum1 is "+sum3);
		
		double currentValue=0,sum4=0;
		for(int count4=1;count4<=100;count4++)
		{
			currentValue+=0.01;
			System.out.println("the "+count4+" is "+currentValue);
			sum4+=currentValue;		
		}
		System.out.println("the sum is "+sum4);
	}
}