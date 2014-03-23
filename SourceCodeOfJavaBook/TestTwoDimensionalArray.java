public class TestTwoDimensionalArray
{
	public static void main(String[] args)
	{
		int[][] martix=new int[5][];
		martix[0]=new int[(int)(Math.random()*10)];
		martix[1]=new int[(int)(Math.random()*10)];
		martix[2]=new int[(int)(Math.random()*10)];
		martix[3]=new int[(int)(Math.random()*10)];
		martix[4]=new int[(int)(Math.random()*10)];

		//create two-dimensional array by random method;
		for(int row=0;row<martix.length;row++)
		{
			for(int column=0;column<martix[row].length;column++)
				martix[row][column]=(int)(Math.random()*100);
		}

		//print two-dimensional array
		for(int row=0;row<martix.length;row++)
		{
			for(int column=0;column<martix[row].length;column++)
			   System.out.printf("%3d",martix[row][column]);
			System.out.println();
		}

		//calculate the sum of the two-dimensional array
		int sum=0;
		for(int row=0;row<martix.length;row++)
		{
			for(int column=0;column<martix[row].length;column++)
				sum+=martix[row][column];
		}
		System.out.println("the sum of the two-dimensional array is "+sum);
		
		//calculate the sum of each column
		int columnMax=martix[0].length;
		for(int row=1;row<martix.length;row++)
		{
			if(columnMax<martix[row].length)
				columnMax=martix[row].length;
		}
		System.out.println("the max value of the column is "+columnMax);

		for(int column=0;column<columnMax;column++)
		{
			int columnSum=0;
			for(int row=0;row<martix.length;row++)
			{
				if(column<martix[row].length)
					columnSum+=martix[row][column];
			}
			System.out.println("the sum of column "+(column+1)+" is "+columnSum);
		}

		//the sum of which row is maximal
		int maxRow=0;
		int indexOfMaxRow=0;
		for(int row=0;row<martix.length;row++)
		{
			int sumOfThisRow=0;
			for(int column=0;column<martix[row].length;column++)
				sumOfThisRow+=martix[row][column];
			System.out.println("the sum of row "+(row+1)+" is "+sumOfThisRow);
			if(maxRow<=sumOfThisRow)
			{
				maxRow=sumOfThisRow;
				indexOfMaxRow=row+1;
			}
		}
		System.out.println("row "+indexOfMaxRow+" has the maximum sum of "+maxRow);
	}
}
