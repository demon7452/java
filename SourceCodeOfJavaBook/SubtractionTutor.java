import javax.swing.JOptionPane;
public class SubtractionTutor
{
	public static void main(String[] args)
	{
		int number1=(int)(Math.random()*10);
		int number2=(int)(Math.random()*10);
		
		if(number1<number2)
		{
			int temp=number1;
			number1=number2;
			number2=temp;
		}
		String answerString=JOptionPane.showInputDialog("what is "+number1+"-"+number2+"?");
		int answer=Integer.parseInt(answerString);
		String replayString;
		if(number1-number2==answer)
			replayString="you are correct!";
		else
			replayString="your answer is wrong!\n"+number1+"-"+number2+" should be "+(number1-number2);
		JOptionPane.showMessageDialog(null,replayString);
	}
}