package com.chapter11.exceptionLogAssertDebug;

import java.io.IOException;

/**
 * 创建自己的异常类
 * create mine exception class
 * @author demon7452
 *
 */
public class MyException extends IOException{
	
	private static final long serialVersionUID = -2471097392298352602L;

	public MyException(){
		super();
	}
	
	public MyException(String message){
		super(message);
	}
}
