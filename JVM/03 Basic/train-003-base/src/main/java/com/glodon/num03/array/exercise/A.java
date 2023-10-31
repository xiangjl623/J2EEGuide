package com.glodon.num03.array.exercise;

public class A {
	
	private int i;
	
	public A(int i) {
		super();
		this.i = i;
	}

	public int getI() {
		return i;
	}

	@Override
	public boolean equals(Object obj) {
		A o = (A) obj;
		
		return i==o.i;
	}
}
