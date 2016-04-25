package com.chapter11.exceptionLogAssertDebug;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 异常处理
 * @author admin
 *
 */
public class HandleExceptionTest {

	private static FileInputStream fileInputStream;

	public static void main(String[] args) {
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
