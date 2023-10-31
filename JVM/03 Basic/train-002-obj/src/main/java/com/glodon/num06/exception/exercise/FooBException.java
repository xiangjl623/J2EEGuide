package com.glodon.num06.exception.exercise;

/**
 * 异常B
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class FooBException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FooBException() {
		super();
	}
	
	public FooBException(Throwable cause) {
		super(cause);
	}
	
	public FooBException(String message) {
		super(message);
	}
	
	public FooBException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
