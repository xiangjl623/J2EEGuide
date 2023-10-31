package com.glodon.num04.exercise;

/**
 * 单例模式
 * 
 * @author fucy
 * @date 2020年7月20日
 * @since JDK1.8
 */
public class Singleton {
	
	private static Singleton _instance = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return _instance;
	}
	
	public void print() {
		System.out.println("Hello Glodon!!! I'm Singleton!!!");
	}
}
