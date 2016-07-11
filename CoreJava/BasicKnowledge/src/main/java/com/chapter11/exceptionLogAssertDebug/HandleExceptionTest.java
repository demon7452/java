package com.chapter11.exceptionLogAssertDebug;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 异常处理
 * @author admin
 *
 */
public class HandleExceptionTest {

	private static FileInputStream fileInputStream;

	public static void main(String[] args) {
		List<Integer> nuls = new ArrayList<Integer>();
		nuls.add(1);
		nuls.add(2);
		boolean test = true;
		for(Integer integer : nuls){
			System.out.println(integer);
			if(test){
				if(1== integer)
					continue;
			}
			System.out.println("end");
		}
		try {
			throwException();
		} catch (Exception e) {
			System.out.println(e);
			Throwable throwable = e.getCause();
			throwable.printStackTrace();
		}
	}
	
	public static void throwException()throws IOException{
		try {
			fileInputStream = new FileInputStream("");
			fileInputStream.read();
		} catch (Exception e) {
			MyException exception = new MyException("create a exception");
			exception.initCause(e);
			throw exception;
		}
	}

}
