package com.glodon.num06.exception.exercise;

/**
 * 异常A
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class FooAException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public FooAException() {
		super();
	}
	
	public FooAException(Throwable cause) {
		super(cause);
	}
	
	public FooAException(String message) {
		super(message);
	}
	
	public FooAException(String message, Throwable cause) {
		super(message, cause);
	}
}
