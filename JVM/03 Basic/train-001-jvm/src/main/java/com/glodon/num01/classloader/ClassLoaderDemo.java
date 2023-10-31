package com.glodon.num01.classloader;


/**
 * ClassLoader（类加载器）验证类
 * 
 * @author fucy
 * @date 2020年7月12日
 * @since JDK1.8
 */
public class ClassLoaderDemo {

	/**
	 * 查看类加载器
	 * 
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// 获取应用类加载器
		ClassLoader applicationClassLoader = ClassLoaderDemo.class.getClassLoader();
		System.out.println("应用类加载器：" + applicationClassLoader);

		// 获取扩展类加载器
		ClassLoader extensionClassLoader = applicationClassLoader.getParent();
		System.out.println("扩展类加载器：" + extensionClassLoader);

		// 获取引导类加载器
		ClassLoader bootstrapClassLoader = extensionClassLoader.getParent();
		System.out.println("引导类加载器:" + bootstrapClassLoader);
		
		// 查看JRE/lib/ext目录下的类的加载器
		System.out.println("ZipPath加载器：" + com.sun.nio.zipfs.ZipPath.class.getClassLoader());
	}

}
