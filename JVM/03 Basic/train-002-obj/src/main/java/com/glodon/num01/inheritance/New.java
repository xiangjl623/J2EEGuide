package com.glodon.num01.inheritance;

/**
 * New类
 * 
 * @author fucy
 * @date 2020年7月21日
 * @since JDK1.8
 */
public class New extends Old {
	
	protected String name;
	
	public New() {
		super();
		this.name = "Default New Name";
	}
	
	public String getThisName() {
		return this.name;
	}
	
	public String getSuperName() {
		return super.name;
	}
}
