public class TestReverseArray
{
	public static void main(String[] args)
	{
		int[] list1={1,2,3,4,5,6};
		int[] list2=reverse(list1);
		for(int element:list2)
			System.out.printf("%3d",element);
	}
	public static int[] reverse(int[] list)
	{
		int[] result=new int[list.length];
		for(int i=0,j=list.length-1;i<list.length;i++,j--)
			result[i]=list[j];
		return result;
	}
}
