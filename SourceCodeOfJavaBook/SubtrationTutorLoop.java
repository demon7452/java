import javax.swing.JOptionPane;
public class SubtrationTutorLoop
{
	public static void main(String[] args)
	{
		int correctCount=0,count=1,total=1;
		long startTime=System.currentTimeMillis();
		String output="";

		while(count<11)
		{	
			int option=0;
			while(option==JOptionPane.YES_OPTION)
			{
				int number1=(int)(Math.random()*100);
				int number2=(int)(Math.random()*100);
				if(number1<number2)
				{
					int temp=number1;
					number1=number2;
					number2=number1;
				}
				String answerString=JOptionPane.showInputDialog(null,"what is "+number1+"-"+number2+" ?",
										"µÚ"+count+"Ìâ",JOptionPane.QUESTION_MESSAGE);
				int answer=Integer.parseInt(answerString);
			
				String replayString;
				if(number1-number2==answer)
				{
					replayString="you are corrected!";
					correctCount++;
				}
				else
					replayString="you are wrong!\n"+number1+"-"+number2+" should be "+(number1-number2);
				JOptionPane.showMessageDialog(null,replayString,"CONSEQUENCE",JOptionPane.INFORMATION_MESSAGE);
		    	output+="\n"+number1+"-"+number2+"="+answer+((number1-number2==answer)?" corrected":" false");
	
		   		option=JOptionPane.showConfirmDialog(null,"Continue?");
		    	if(option==JOptionPane.YES_OPTION)
		    	{
		    		System.out.println("continue loop "+count);
		    		count++;
		    		total=count;
		    	}
		   		else
		    		count=11;
		   	}
		}
		long endTime=System.currentTimeMillis();
		long testTime=(endTime-startTime)/1000;
		JOptionPane.showMessageDialog(null,"total count is "+total+"\nCorrect count is "+correctCount+"\ntest time is "+testTime+
						" seconds"+output,"test consequence ",JOptionPane.INFORMATION_MESSAGE);
	}
}