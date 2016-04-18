package com.chapter06.interfaceAndInnerClass;
/**
 * 静态内部类测试
 * @author demon7452
 *
 */
public class StaticInnerClassTest {

	public static void main(String[] args) {
		double[] values = new double[20];
		for(int i =0; i<values.length; i++){
			values[i] = (int)(100 * Math.random());
			System.out.print(values[i] + ",  ");
		}
		System.out.println();
		ArrayAlg.Pair pair = ArrayAlg.minmax(values);
		System.out.println("min:" + pair.getMin() + " max:" + pair.getMax());

	}

}
class ArrayAlg{
	public static class Pair{
		private double min;
		private double max;
		public Pair(double min,double max){
			this.min = min;
			this.max = max;
		}
		public double getMin() {
			return min;
		}
		public double getMax() {
			return max;
		}
	}
	
	public static Pair minmax(double[] values) {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for(double value : values){
			if(value < min)
				min = value;
			if(value > max)
				max = value;
		}
		return new Pair(min, max);
	}
}