import java.util.Date;
public class TestDate
{
	public static void main(String[] args)
	{
			Date date=new Date();
			System.out.println("the elapsed time since Jan 1,1970 is "+date.getTime()+" milliseconds");
			System.out.println(date.toString());

			Date date2=new Date(1111111);
			System.out.println("the elapsed time since Jan 1,1970 is "+date2.getTime()+" milliseconds");
			System.out.println(date2.toString());

	}
}
