package com.charpter6.interfaceAndInnerClass;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * 代理测试,没怎么看懂啊
 * @author demon7452
 *
 */
public class ProxyTest {

	public static void main(String[] args) {
		Object[] elements = new Object[1000];
		for(int i =0; i< elements.length; i++){
			Integer value = i + 1;
			TraceHandler handler = new TraceHandler(value);//创建一个调用处理器
			Object proxy = Proxy.newProxyInstance(null,new Class[]{Serializable.class,Comparable.class}, handler);//创建一个代理，（类加载器，对象数组，调用处理器）
			elements[i] = proxy;
		}
		Integer key = new Random().nextInt(elements.length)+1;
		int result = Arrays.binarySearch(elements, key);
		if(result >= 0)
			System.out.println("elements["+result+"]="+elements[result]);
	}
}
class TraceHandler implements InvocationHandler{
	private Object target;
	public TraceHandler(Object target){
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.print(target+"."+method.getName()+"(");
		if(null != args){
			for(int i =0; i< args.length; i++){
				if(i>0)
					System.out.print(",");
				System.out.print(args[i]);
			}
		}
		System.out.println(")");
		return method.invoke(target, args);
	}
}