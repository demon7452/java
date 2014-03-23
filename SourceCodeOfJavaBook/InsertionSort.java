public class InsertionSort
{
	public static void main(String[] args)
	{
		int[] list={6,4,8,2,5,1};
		insertionSort(list);
		for(int element:list)
			System.out.printf("%3d",element);
	}
	public static void insertionSort(int[] list)
	{
		for(int i=1;i<list.length;i++)
		{
			int currentElement=list[i];
			int j;
			for(j=i-1;j>=0&&list[j]>currentElement;j--)
				list[j+1]=list[j];
			list[j+1]=currentElement;
		}
	}
}
