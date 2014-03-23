import javax.swing.JOptionPane;
public class RationalTest
{
	public static void main(String[] args)
	{
		Rational r1=new Rational(-4,-2);
		Rational r2=new Rational(2,3);
		System.out.println("r1+r2 is "+r1.add(r2));
		System.out.println("r1+r2 is "+r1.subtract(r2));
		System.out.println("r1+r2 is "+r1.multiply(r2));
		System.out.println("r1+r2 is "+r1.divide(r2));
	}
}
