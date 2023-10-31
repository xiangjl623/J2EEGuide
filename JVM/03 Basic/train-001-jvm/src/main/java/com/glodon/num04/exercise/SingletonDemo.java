package com.glodon.num04.exercise;

/**
 * 单例模式示例
 * 
 * @author fucy
 * @date 2020年7月20日
 * @since JDK1.8
 */
public class SingletonDemo {
	
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		
		Singleton s2 = Singleton.getInstance();
		
		System.out.println("是否为同一对象：" + (s1==s2));
	}
	
}
