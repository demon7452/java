import java.util.Calendar;
public class TestCalendar
{
	public static void main(String[] args)
	{
		Calendar calendar=new java.util.GregorianCalendar();
		System.out.println("year\tmonth\tdate\thour\tminute\tsecond");
		System.out.println(calendar.get(Calendar.YEAR)+"\t"+(calendar.get(Calendar.MONTH)+1)+"\t"+calendar.get(Calendar.DATE)+"\t"+
				calendar.get(Calendar.HOUR_OF_DAY)+"\t"+calendar.get(Calendar.MINUTE)+"\t"+calendar.get(Calendar.SECOND));
		System.out.println("day of week "+(calendar.get(Calendar.DAY_OF_WEEK)-1));
	}
}
