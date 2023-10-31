package com.glodon.num01.anno;

import java.lang.reflect.Method;

/**
 * 注解示例
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class AnnoDemo {
	
	public static void main(String[] args) throws Exception {
		Method method = AnnoDemo.class.getMethod("myMethod");
		
		if (method.isAnnotationPresent(UseCase.class)) {
			UseCase useCase = method.getAnnotation(UseCase.class);
			
			System.out.println("UseCase注解中，id=" + useCase.id() + " , description="
					+ useCase.description());
		} else {
			System.out.println("无UseCase注解");
		}
	}
	
	/**
	 * 注解方法
	 */
	@UseCase(id = 1, description = "My Method")
	public void myMethod() {
		
	}
}
