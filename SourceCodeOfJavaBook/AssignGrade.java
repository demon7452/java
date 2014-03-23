import javax.swing.JOptionPane;
public class AssignGrade
{
	public static void main(String[] args)
	{
		String numberOfStudentsString=JOptionPane.showInputDialog("enter number of students:");
		int numberOfStudents=Integer.parseInt(numberOfStudentsString);
		
		int[] scores=new int[numberOfStudents];
		int best=0;
		String grade;
		for(int i=0;i<scores.length;i++)
		{
			String scoreString=JOptionPane.showInputDialog("enter a score:");
			
			scores[i]=Integer.parseInt(scoreString);
			if(scores[i]>best)
				best=scores[i];
		}
		String output="";
		for(int i=0;i<scores.length;i++)
		{
			if(scores[i]>=best-10)
				grade="A";
			else if(scores[i]>=best-20)
				grade="B";
			else if(scores[i]>=best-30)
				grade="C";
			else if(scores[i]>=best-40)
			 	grade="D";
			else
				grade="E";
			output+="student "+i+" score is "+scores[i]+" and grade is "+grade+"\n";
		}
		JOptionPane.showMessageDialog(null,output);
	}
}