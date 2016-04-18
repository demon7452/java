package com.chapter05.abstractClass;
/**
 * �����ɱ����
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
	 * ���Դ������⼸������
	 * ��ȡ���ֵ
	 * @param vlaues �������
	 * @return ����double
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
