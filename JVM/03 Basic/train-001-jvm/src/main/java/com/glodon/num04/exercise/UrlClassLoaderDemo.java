package com.glodon.num04.exercise;

import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 运行时数据示例
 * 
 * @author fucy
 * @date 2020年7月20日
 * @since JDK1.8
 */
public class UrlClassLoaderDemo {

	public static void main(String[] args) throws Exception {
		URL url = new File("G:\\JAVA基础\\Java基础源码\\train-001-jvm\\src\\main\\java\\com\\glodon\\other").toURI().toURL();
		URL[] urls = { url };

		// 获取类加载系统的管理接口
		ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();

		try (URLClassLoader classLoader = new URLClassLoader(urls)) {
			System.out.println("加载类的个数: " + loadingBean.getLoadedClassCount());

			System.out.println("加载RunJavaDemo类...");
			classLoader.loadClass("RunJavaDemo");

			System.out.println("当前加载的个数: " + loadingBean.getLoadedClassCount());
		}
	}

}
