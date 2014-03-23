public class GradeExam
{
	public static void main(String[] args)
	{
		char[][] answers=
		{
			{'a','b','a','c','d','a'},
			{'c','b','d','c','d','b'},
			{'b','d','c','a','c','d'}
		};
		char[] key={'a','b','c','d','a','b'};
		for(int row=0;row<answers.length;row++)
		{
			int correctCount=0;
			System.out.print("the answer of student "+(row+1)+" is ");
			for(int column=0;column<answers[row].length;column++)
			{
				if(answers[row][column]==key[column])
					correctCount++;
				System.out.printf("%3c",answers[row][column]);
			}
			System.out.println(" and the correct count is "+correctCount);
		}
	}
}
