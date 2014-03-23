public class TestPassArray
{
	public static void main(String[] args)
	{
		int[] a={1,2};
		System.out.println("before invoking swap,the array is {"+a[0]+","+a[1]+"}" );
		swap(a[0],a[1]);
		System.out.println("after invoking swap,the array is {"+a[0]+","+a[1]+"}" );
		
		System.out.println("before invoking swapArray,the array is {"+a[0]+","+a[1]+"}" );
		swapArray(a);
		System.out.println("before invoking swapArray,the array is {"+a[0]+","+a[1]+"}" );
	}
	public static void swap(int n1,int n2)
{
	int temp=n1;
	n1=n2;
	n2=temp;
}
public static void swapArray(int[] array)
{
	int temp=array[0];
	array[0]=array[1];
	array[1]=temp;
}
}
