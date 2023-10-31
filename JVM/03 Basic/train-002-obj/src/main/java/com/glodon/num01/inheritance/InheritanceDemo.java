package com.glodon.num01.inheritance;

/**
 * 继承示例
 * 
 * @author fucy
 * @date 2020年7月21日
 * @since JDK1.8
 */
public class InheritanceDemo {
	
	public static void main(String[] args) {
		New n = new New();
		
		System.out.println("默认名字： " + n.getName());
		System.out.println("this名字： " + n.getThisName());
		System.out.println("super名字： " + n.getSuperName());
	}
	
}
