public class SelectionSort
{
	public static void main(String[] args)
	{
		double[] list={4,7,3,2,9,11,55,0};
		SelectionSort(list);
		for(double element:list)
			System.out.println(element);
	}
	public static void SelectionSort(double[] list)
	{
		for(int i=list.length-1;i>=1;i--)
		{
			int currentMaxIndex=0;
			for(int j=1;j<=i;j++)
			{
				if(list[currentMaxIndex]<list[j])
					currentMaxIndex=j;
			}
			if(currentMaxIndex!=i)
			{
				double temp=list[currentMaxIndex];
				list[currentMaxIndex]=list[i];
				list[i]=temp;
			}
		}
	}

}
