package com.charpter3;
public class LoopStatementTest
{
	public static void main(String[] args)
	{
		int i = 0;
		boolean status = true;
		break_lable: //跳出整个循环，且该循环不再执行
		for (;i<10;i++)
		{
			status = true;
			while(status)
			{
				status = false;
				if(i == 6)
				{
					break break_lable;
//					break;
				}
				System.out.println(i);
			}
		}
		System.out.println("hello world");
	}
}
