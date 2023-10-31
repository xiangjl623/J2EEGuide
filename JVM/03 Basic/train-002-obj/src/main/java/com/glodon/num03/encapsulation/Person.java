package com.glodon.num03.encapsulation;

/**
 * 人员类
 * 1. 属性信息封装起来
 * 2. 暴露设置或获取方法
 * 
 * @author fucy
 * @date 2020年7月25日
 * @since JDK1.8
 */
public class Person {
	private String name;
	
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
