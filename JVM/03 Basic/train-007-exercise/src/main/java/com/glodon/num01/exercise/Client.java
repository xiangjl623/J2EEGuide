package com.glodon.num01.exercise;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 * 示例
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class Client {
	
	public static void main(String[] args) {
		Result<Person> r1 = new Result<Person>(new Person("zhangsan", 20));
		
		System.out.println("泛型对象：" + r1);
		
		String base64 = toBase64(r1.getBytes());
		System.out.println("转换为Base64：" + base64);
		
		byte[] objBytes = toBytes(base64);
		Result<Person> r2 = new Result<Person>(objBytes, Person.class);
		
		System.out.println("反序列后的泛型对象：" + r2);
	}
	
	/**
	 * 转换为Base64
	 * 
	 * @param bytes
	 * @return
	 */
	public static String toBase64(byte[] bytes) {
		Encoder encoder = Base64.getEncoder();
		
		try {
			return new String(encoder.encode(bytes), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Base64转换为字节数组
	 * 
	 * @param base64
	 * @return
	 */
	public static byte[] toBytes(String base64) {
		Decoder decoder = Base64.getDecoder();
		
		try {
			byte[] bytes = base64.getBytes("UTF-8");
			
			return decoder.decode(bytes);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
