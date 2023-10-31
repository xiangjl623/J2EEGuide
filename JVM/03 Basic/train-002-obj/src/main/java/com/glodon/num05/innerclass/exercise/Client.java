package com.glodon.num05.innerclass.exercise;

public class Client {
	
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		U u1 = a.createU("One");
		U u2 = a.createU("Two");
		U u3 = a.createU("Three");
		
		b.add(u1);
		b.add(u2);
		b.add(u3);
		
		b.view();
	}
	
}
