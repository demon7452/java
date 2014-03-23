import javax.swing.JOptionPane;
public class FindSalesAmount
{
	public static void main(String[] args)
	{
		String anticipateString=JOptionPane.showInputDialog("how munch do you want to get?");
		double anticipate=Double.parseDouble(anticipateString);
		
		double salesAmount=0;
		double commission=0;
		while(commission<(anticipate-5000))
		{	
			salesAmount+=0.01;
			if(salesAmount>=10000.01)
			{
				commission=5000*0.18+(salesAmount-10000)*0.12;
			}
			else if(salesAmount>=5000)
			{
				commission=5000*0.08+(salesAmount-5000)*0.1;
			}
			else
				commission=salesAmount*0.08;
			
		}
		JOptionPane.showMessageDialog(null,"the sales amount is $"+(int)(salesAmount*100)/100.0+
									 "\nyou can get your commission money "+anticipate);	
	}
}