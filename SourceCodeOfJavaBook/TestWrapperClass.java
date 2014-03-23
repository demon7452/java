import java.math.BigDecimal;
public class TestWrapperClass
{
	public static void main(String[] args)
	{
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Short.MIN_VALUE);
		System.out.println(Long.MIN_VALUE);
		System.out.println(Double.MIN_VALUE);

		double d=5.9;
		Double doubleObject=new Double(d);
		String s=doubleObject.toString();

		System.out.println(Integer.parseInt("11",2));

		BigDecimal a=new BigDecimal(1.0);
		BigDecimal b=new BigDecimal(3);
		BigDecimal c=a.divide(b,20,BigDecimal.ROUND_UP);
		System.out.println(c);
	}
}
