package com.glodon.num06.exception.exercise;

public class Client {
	
	public static void main(String[] args) {
		Client c = new Client();
		
		try {
			c.g();
		} catch (FooAException e) {
			e.printStackTrace();
		}
		
		c.f();
	}
	
	public void f() {
		throw new FooBException();
	}
	
	public void g() throws FooAException {
		throw new FooAException();
	}
}
