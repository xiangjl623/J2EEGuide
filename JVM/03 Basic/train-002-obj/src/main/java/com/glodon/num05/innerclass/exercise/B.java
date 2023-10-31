package com.glodon.num05.innerclass.exercise;

/**
 * B类
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class B {
	
	private U[] uArray = new U[20];
	private int index = 0;
	
	public void add(U u) {
		uArray[index] = u;
		index++;
	}
	
	public void view() {
		for (int i = 0; i < index; i++) {
			U u = uArray[i];
			
			u.a();
			u.b();
			u.c();
		}
	}
	
}
