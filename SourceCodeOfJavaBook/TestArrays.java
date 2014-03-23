import java.util.Arrays;
public class TestArrays
{
	public static void main(String[] args)
	{
		//sort the whole array
		double[] numbers={6.0,4.4,1.9,2.9,3.4,3.5};
		java.util.Arrays.sort(numbers);
		for(double e:numbers)
			System.out.print(e+"  ");
		
		//sort the part of array
		char[] chars={'a','A','4','F','D','P'};
		java.util.Arrays.sort(chars,1,3);
		for(char c:chars)
			System.out.print(c+"  ");

		//use binary search to find the key in the list
		int[] list={1,2,3,4,5,6,7};
		System.out.println("the index of 3 is "+java.util.Arrays.binarySearch(list,3));

		//equals
		int[] list2={1,2,3};
		int[] list3=list;
		System.out.println(java.util.Arrays.equals(list,list2));
		System.out.println(java.util.Arrays.equals(list,list3));

		//fill the array
		java.util.Arrays.fill(list,5);
		for(int e:list)
			System.out.print(e+"  ");
		System.out.println();

		java.util.Arrays.fill(list,1,3,8);
		for(int e:list)
			System.out.print(e+"  ");
	}
}
