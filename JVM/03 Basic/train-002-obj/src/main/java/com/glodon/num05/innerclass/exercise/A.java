package com.glodon.num05.innerclass.exercise;

/**
 * A类，创建U的实现类
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class A {
	
	public U createU(final String name) {
		return new U() {
			@Override
			public void a() {
				System.out.println("A --> a(" + name + ")");
			}
			
			@Override
			public void b() {
				System.out.println("A --> b(" + name + ")");
			}
			
			@Override
			public void c() {
				System.out.println("A --> c(" + name + ")");
			}
		};
	}
	
}
