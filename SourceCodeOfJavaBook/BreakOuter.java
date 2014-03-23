public class BreakOuter
{
	public static void main(String[] args)
	{
		outer:
		for(int i=1;i<10;i++)
		{
			inner:
			for(int j=1;j<10;j++)
			{
				if(i*j>50)
					break outer;
				System.out.println(i*j);
			}
		}
		System.out.println("end");
		
		outer:
		for(int i=1;i<10;i++)
		{
			inner:
			for(int j=1;j<10;j++)
			{
				if(i*j>50)
					continue inner;
				System.out.println(i*j);
			}
		}
		System.out.println("end");
		
	}
}