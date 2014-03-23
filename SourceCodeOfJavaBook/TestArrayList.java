public class TestArrayList
{
	public static void main(String[] args)
	{
		java.util.ArrayList cityList=new java.util.ArrayList();

		cityList.add("london");
		cityList.add("new york");
		cityList.add("paris");
		cityList.add("toronto");
		cityList.add("hong kong");
		cityList.add("singapore");
		System.out.println("list size"+cityList.size());
		System.out.println("is toronto in the list"+cityList.contains("toronto"));
		System.out.println("the location of new york in the list?"+cityList.indexOf("new york"));
		System.out.println("is the list empty"+cityList.isEmpty());

		cityList.add(2,"beijing");
		cityList.remove("toronto");
		cityList.remove(1);

		for(int i=0;i<cityList.size();i++)
		{
			System.out.print(cityList.get(i)+"  ");
		}
		System.out.println();

		java.util.ArrayList list=new java.util.ArrayList();
		list.add(new lixiong.Circle(3));
		list.add(new lixiong.Circle(5));

		System.out.println("the area of the circle?"+((lixiong.Circle)list.get(0)).getArea());
		System.out.println("the area of the circle?"+((lixiong.Circle)list.get(1)).getArea());
	}
}
