
	class SWK
	{
		int age=566;
		int height=163;
		int weight=60;
		String speak="³Ô°³ÀÏËïÒ»°ô¡£";
	
		String output="ËïÎò¿Õ:\n"+"age is "+age+" years old;\n"+"height is "+height+"cm;\n"+
					"weight is "+weight+"kg;\n"+"speak:"+speak;
		void print()
		{
			System.out.println(output);
		}			
		
	}
	class ZBJ
	{
		int age=1266;
		int height=173;
		int weight=300;
		String speak="×Ô¹Å¶àÇé¿ÕÓàºŞ,´ËºŞÃàÃàÎŞ¾øÆÚ¡£";
	
		String output="Öí°Ë½ä:\n"+"age is "+age+" years old;\n"+"height is "+height+"cm;\n"+
					"weight is "+weight+"kg;\n"+"speak:"+speak;
		void print()
		{
			System.out.println(output);
		}			
		
	}
public class XYJ
{

	public static void main(String[] args)
	{
		SWK A=new SWK();
		A.print();
	
		ZBJ B=new ZBJ();
		B.print();
		

	}
}