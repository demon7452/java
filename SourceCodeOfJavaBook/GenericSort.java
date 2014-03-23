public class GenericSort
{
	public static void main(String[] args)
	{
		Integer[] intArray={new Integer(2),new Integer(5),new Integer(3)};
		Double[] doubleArray={new Double(3.4),new Double(2.1),new Double(44.3)};
		Character[] charArray={new Character('a'),new Character('A'),new Character('c')};
		String[] stringArray={"tom","john","amay"};

		selectionSort(intArray);
		selectionSort(doubleArray);
		insertionSort(charArray);
		insertionSort(stringArray);

		printList(intArray);
		printList(doubleArray);
		printList(charArray);
		printList(stringArray);
	}
	public static void selectionSort(Object[] list)
	{
		Object currentMax;
		int currentMaxIndex;
		for(int i=list.length-1;i>=1;i--)
		{
			currentMax=list[i];
			currentMaxIndex=i;
			for(int j=i-1;j>=0;j--)
			{
				if(((Comparable)currentMax).compareTo(list[j])<0)
				{
					currentMax=list[j];
					currentMaxIndex=j;
				}
			}
			if(currentMaxIndex!=i)
			{
				list[currentMaxIndex]=list[i];
				list[i]=currentMax;
			}
		}
	}
    public static void insertionSort(Object[] list)
	{
		for(int i=1;i<list.length;i++)
		{
			Object currentElement=list[i];
			int j;
			for(j=i-1;j>=0&&((Comparable)currentElement).compareTo(list[j])<0;j--)
				list[j+1]=list[j];
			list[j+1]=currentElement;
		}
	}
	public static void printList(Object[] list)
	{
		for(int i=0;i<list.length;i++)
			System.out.print(list[i]+"   ");
		System.out.println();
	}
}
