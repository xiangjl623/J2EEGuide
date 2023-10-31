package com.glodon.num02.container.exercise;

/**
 * 类 A
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class A implements Comparable<A> {

	private String a1;
	
	private String a2;

	public A(String a1, String a2) {
		super();
		this.a1 = a1;
		this.a2 = a2;
	}

	@Override
	public int compareTo(A o) {
		if (a2==null && o.a2==null) return 0;
		
		if (a2==null) return 1;
		
		if (o.a2==null) return -1;
		
		return a2.compareTo(o.a2);
	}
	
	public String getA1() {
		return a1;
	}
	
	public String getA2() {
		return a2;
	}

	@Override
	public String toString() {
		return "A [a1=" + a1 + ", a2=" + a2 + "]";
	}
}
