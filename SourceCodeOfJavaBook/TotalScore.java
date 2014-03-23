public class TotalScore
{
	public static void main(String[] args)
	{
		double[][][] scores=
		{
			{{7.5,20.5},{9.0,22.5},{15,33.5}},
			{{7.5,10.5},{9.0,12.5},{15,13.5}},
			{{7.5,20.5},{9.0,22.5},{15,33.5}},
			{{7.5,20.5},{9.0,22.5},{15,33.5}}
		};
		for(int i=0;i<scores.length;i++)
		{
			double totalScore=0;
			for(int j=0;j<scores[i].length;j++)
			{
				for(int k=0;k<scores[i][j].length;k++)
					totalScore+=scores[i][j][k];
			}
			System.out.println("the total score of student "+(i+1)+" is "+totalScore);
		}
	}
}
