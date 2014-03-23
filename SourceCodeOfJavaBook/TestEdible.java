interface Edible
{
	String howToEat();
}
class Animal
{
}
class Chicken extends Animal implements Edible
{
	public String howToEat()
	{
		return "fry it";
	}
}
class Tiger extends Animal
{
}


abstract class Fruit implements Edible
{
}
class Apple extends Fruit
{
	public String howToEat()
	{
		return "make apple cider";
	}
}
class Orange extends Fruit
{
	public String howToEat()
	{
		return "make orange juice";
	}
}

public class TestEdible
{
	public static void main(String[] args)
	{
		Object[] objects={new Chicken(),new Tiger(),new Apple(),new Orange()};
		for (int i=0;i<objects.length;i++)
			showObject(objects[i]);
	}
	public static void showObject(Object o)
	{
		if(o instanceof Edible)
			System.out.println(((Edible)o).howToEat());
		else 
			System.out.println("can't eat");
	}
}
