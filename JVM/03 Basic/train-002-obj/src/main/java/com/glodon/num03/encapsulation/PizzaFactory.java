package com.glodon.num03.encapsulation;

/**
 * 披萨工厂（封装）
 * 
 * @author fucy
 * @date 2020年7月21日
 * @since JDK1.8
 */
public abstract class PizzaFactory {
	
	public PizzaFactory() {
		make();
	}
	
	// 准备材料
	public abstract void ready();
	
	// 烘烤
	public abstract void bake();
	
	/**
	 * 制作（将制作流程封装起来）
	 */
	private void make() {
		ready();
		bake();
	}
	
}
