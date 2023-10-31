package com.glodon.num03.encapsulation;

/**
 * 北京披萨工厂
 * 
 * @author fucy
 * @date 2020年7月25日
 * @since JDK1.8
 */
public class BjPizzaFactory extends PizzaFactory {

	@Override
	public void ready() {
		System.out.println("北京准备材料");
	}

	@Override
	public void bake() {
		System.out.println("在北京烘烤");
	}

}
