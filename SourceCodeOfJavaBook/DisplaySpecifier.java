import javax.swing.JOptionPane;
public class DisplaySpecifier
{
	public static void main(String[] args)
	{
		boolean booleanTest=true;
		char charTest='x';
		int decimal=66;
		double floatTest=45.689500;
		double Enotation=5.555672e+12;
		String stringTest="test specifier!";
		System.out.printf("boolean:%8b \ncharacter:%10c \ndecimal:%5d \nfloat:%10.3f"+
		"\nE-notation:%19.2e \nstring:%19s\n",
		                   booleanTest,charTest,decimal,floatTest,Enotation,stringTest);
		System.out.printf("%8d%8s\n",1234,"java");
		System.out.printf("%-8d%-8s\n",1234,"java");
		String s=String.format("float:%10.4f\nstring:%30s",floatTest,stringTest);
		JOptionPane.showMessageDialog(null,s);
	}
}