package com.charpter5.abstractClass;
/**
 * 参数可变测试
 * @author admin
 *
 */
public class VariableParameterTest {

	public static void main(String[] args) {
		System.out.println(getMax(1.0));
		System.out.println(getMax(1.0,2.1,2.3));
		System.out.println(getMax(11.56666,1.0,2.1,2.3));
	}
	
	/**
	 * 
	 * 可以传入任意几个参数
	 * 获取最大值
	 * @param vlaues
	 * @return
	 */
	public static double getMax(double... vlaues ) {
		double max = Double.MIN_VALUE;
		for(double v:vlaues){
			if(v >= max)
				max = v;
		}
		return max;
	}

}
