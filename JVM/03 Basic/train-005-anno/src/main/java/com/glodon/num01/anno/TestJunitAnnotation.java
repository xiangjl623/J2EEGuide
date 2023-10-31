package com.glodon.num01.anno;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 测试注解示例
 * 
 * @author fucy
 * @date 2020年7月27日
 * @since JDK1.8
 */
public class TestJunitAnnotation {
	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class:begin this class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("after class:end this class");
	}

	@Before
	public void before() {
		System.out.println("before:begin test");
	}

	@After
	public void after() {
		System.out.println("after:end test");
	}

	@Test
	public void Test() {
		System.out.println("[this is a test!]");
	}

	@Test
	public void Test2() {
		System.out.println("[this is another test!]");
	}
}
