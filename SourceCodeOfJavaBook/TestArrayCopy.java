public class TestArrayCopy
{
	public static void main(String[] args)
	{
		int[] sourceArray={1,2,3,4,5,6,7};
		int[] targetArray1=new int[7];
		int[] targetArray2=new int[7];

		for(int i=0;i<7;i++)
		{
			targetArray1[i]=sourceArray[i];
		}
		for(int element:targetArray1)
			System.out.printf("%3d",element);
		System.arraycopy(sourceArray,0,targetArray2,0,7);
		for(int element:targetArray2)
			System.out.printf("%3d",element);
	}
}
