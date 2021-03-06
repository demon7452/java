public class FinalizationDemo
{
	public static void main(String[] args)
	{
		Cake c1=new Cake(1);
		Cake c2=new Cake(2);
		Cake c3=new Cake(3);

	  c2=c3=null;
		System.gc();//invoke the java garbage collector
	}
}
class Cake extends Object
{
	private int id;

	public Cake(int id)
	{
		this.id=id;
		System.out.println("cake object "+id+" is created.");
	}

	protected void finalize() throws java.lang.Throwable
	{
		super.finalize();
		System.out.println("cake object "+id+" is disposed.");
	}
}
