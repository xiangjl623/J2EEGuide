package com.glodon.num04.exercise;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象初始化示例
 * 
 * @author fucy
 * @date 2020年7月25日
 * @since JDK1.8
 */
public class ObjectInitDemo {
	
	public static void main(String[] args) throws Exception {
		// new方式初始化对象
		Person p1 = new Person("New的对象p1");
		System.out.println(p1);
		
		// 使用Class类的newInstance
		Person p2 = Person.class.newInstance();
		p2.setName("使用Class类的newInstance对象p2");
		System.out.println(p2);
		
		// 使用Constructor类的newInstance
		Person p3 = Person.class.getConstructor(String.class).newInstance("使用Constructor方法的newInstance对象p3");
		System.out.println(p3);
		
		// 使用Clone方法创建对象
		Person p4 = (Person) p3.clone();
		System.out.println("p4还是不是p3：" + p3.equals(p4));
		p4.setName("使用Clone方法创建对象p4");
		System.out.println(p4);
		
		// 使用(反)序列化机制创建对象
		byte[] objArray = null;
		
		try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(p1);
			objectOutputStream.flush();
			
			objArray = byteArrayOutputStream.toByteArray();
		}
		
		System.out.println("p1对象字节数：" + objArray.length);
		
		// 反序列化
		try(ByteArrayInputStream inputStream = new ByteArrayInputStream(objArray)){
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			
			Person p5 = (Person)objectInputStream.readObject();
			System.out.println("p5还是不是p1：" + p3.equals(p4));
			p5.setName("使用(反)序列化机制创建对象p5");
			System.out.println(p5);
		}
	}
	
}

/**
 * 人员类
 * 
 * @author fucy
 * @date 2020年7月25日
 * @since JDK1.8
 */
class Person implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public Person() {
		super();
	}
	
	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Object clone() {
		Person p = null;
		
		try {
			// 浅拷贝
			p = (Person) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("复制对象失败", e);
		}
		
		return p;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}
