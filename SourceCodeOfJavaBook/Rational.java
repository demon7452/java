public class Rational extends Number implements Comparable
{
	private long numerator=0;
	private long denominator=1;

	public Rational()
	{
		this(0,1);
	}
	public Rational(long numerator,long denominator)
	{
		if(denominator==0)
		{
			System.out.println("the denominator can't be zero");
			System.exit(0);
		}
		else
		{
			long gcd=gcd(numerator,denominator);
			this.numerator=((denominator>0)?1:-1)*numerator/gcd;
			this.denominator=Math.abs(denominator)/gcd;
		}
	}
	private static long gcd(long numerator,long denominator)
	{
		long n=Math.abs(numerator);
		long d=Math.abs(denominator);
		int gcd=1;
		for(int k=1;k<=n&&k<=d;k++)
		{
			if(n%k==0 && d%k==0)
				gcd=k;
		}
		return gcd;
	}
	public long getNumerator()
	{
		return numerator;
	}
	public long getDenominator()
	{
		return denominator;
	}

	public String add(Rational secondRational)
	{
		long n=numerator*secondRational.getDenominator()+denominator*secondRational.getNumerator();
		long d=denominator*secondRational.getDenominator();
		return new Rational(n,d).toString();
	}
	public String subtract(Rational secondRational)
	{
		long n=numerator*secondRational.getDenominator()-denominator*secondRational.getNumerator();
		long d=denominator*secondRational.getDenominator();
		return new Rational(n,d).toString();
	}
	public String multiply(Rational secondRational)
	{
		long n=numerator*secondRational.getNumerator();
		long d=denominator*secondRational.getDenominator();
		return new Rational(n,d).toString();
	}
	public String divide(Rational secondRational)
	{
		long n=numerator*secondRational.getDenominator();
		long d=denominator*secondRational.getNumerator();
		return new Rational(n,d).toString();
	}
	public String toString()
	{
		if(denominator==1)
			return numerator+"";
		else 
			return numerator+"/"+denominator;
	}
	public double doubleValue()
	{
		return numerator*1.0/denominator;
	}
	public int intValue()
	{
		return (int)doubleValue();
	}
	public float floatValue()
	{
		return (float)doubleValue();
	}
	public long longValue()
	{
		return (long)doubleValue();
	}
	public int compareTo(Object o)
	{
		return 1;
	}
}
