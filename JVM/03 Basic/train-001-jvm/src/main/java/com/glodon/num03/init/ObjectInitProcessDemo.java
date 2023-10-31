package com.glodon.num03.init;

/**
 * 对象初始化过程示例
 * 
 * @author fucy
 * @date 2020年7月20日
 * @since JDK1.8
 */
public class ObjectInitProcessDemo {
	
	public static void main(String[] args) {
		new Son();
	}
	
}

/**
 * 父类
 * 
 * @author fucy
 * @date 2020年7月25日
 * @since JDK1.8
 */
class Father {
	
	static int num = 20;
	
	static {
		System.out.println("Father静态属性已经初始化【num=" + num + "】");
		
		System.out.println("Father静态代码块被调用");
	}
	
	String name = "no father name";
	
	{
		System.out.println("Father非静态属性已经初始化【name = '" + name + "'】");
		
		System.out.println("Father非静态代码块被调用");
	}
	
	public Father() {
		System.out.println("Father构造方法被调用");
	}
}

/**
 * 子类
 * 
 * @author fucy
 * @date 2020年7月25日
 * @since JDK1.8
 */
class Son extends Father {
	
	static int num = 10;
	
	static {
		System.out.println("Son静态属性已经初始化【num=" + num + "】");
		
		System.out.println("Son静态代码块被调用");
	}
	
	String name = "no son name";
	
	{
		System.out.println("Son非静态属性已经初始化【name = '" + name + "'】");
		
		System.out.println("Son非静态代码块被调用");
	}
	
	public Son() {
		System.out.println("Son构造方法被调用");
	}
	
}