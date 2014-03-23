public class LinearSearch
{
	public static void main(String[] args)
	{
		int[] list={1,2,3,4,5,6,7};
		System.out.println("the key of 7 is "+linearSearch(list,7));
	}
	public static int linearSearch(int[] list,int key)
	{
		for(int i=0;i<list.length;i++)
		{
			if(key==list[i])
				return i;
		}
		return -1;
	}
}
