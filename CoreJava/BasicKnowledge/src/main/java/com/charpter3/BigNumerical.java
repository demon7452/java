package com.charpter3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigNumerical
{
	public static void main(String[] args)
	{
//		bigIntegerTest();  
		bigDecimalTest();
	}
	
	/**
	 * BigInteger 任意精度的整数运算 
	 */
	private static void bigIntegerTest()
	{
		BigInteger bigInteger1 = BigInteger.valueOf(100);
		BigInteger bigInteger2 = BigInteger.valueOf(123);
		
		System.out.println((bigInteger1.add(bigInteger2)).toString());
		System.out.println((bigInteger2.subtract(bigInteger1)).toString());
		System.out.println((bigInteger1.multiply(bigInteger2)).toString());
		System.out.println(bigInteger2.divide(bigInteger1).toString());
	}
	
	/**
	 * BigDecimal 任意精度的浮点数运算
	 */
	private static void bigDecimalTest()
	{
		BigDecimal bigDecimal1 = BigDecimal.valueOf(10.235);
		BigDecimal bigDecimal2 = BigDecimal.valueOf(10.22222);
		
		System.out.println(bigDecimal1.add(bigDecimal2).toString());
		System.out.println(bigDecimal1.subtract(bigDecimal2).toString());
		System.out.println(bigDecimal1.multiply(bigDecimal2).toString());
		System.out.println(bigDecimal1.divide(BigDecimal.valueOf(10)).toString());
		System.out.println(bigDecimal1.divide(bigDecimal2, RoundingMode.HALF_UP).toString());
		System.out.println(bigDecimal1.divide(bigDecimal2, 7, RoundingMode.HALF_UP));
	}
}
