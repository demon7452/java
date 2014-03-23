public class BinarySearch
{
	public static void main(String[] args)
	{
		int[] list={1,2,3,4,5,6,7,8,9,10};
		System.out.println("the key of 6 is "+binarySearch(list,6));
	}
	public static int binarySearch(int[] list,int key)
	{
		int low=0;
		int high=list.length-1;
		while(low<=high)
		{
			int mid=(high+low)/2;
			if(key<list[mid])
				high=mid-1;
			else if(key==list[mid])
				return mid;
			else
				low=mid+1;
		}
		return -low-1;
	}
}
