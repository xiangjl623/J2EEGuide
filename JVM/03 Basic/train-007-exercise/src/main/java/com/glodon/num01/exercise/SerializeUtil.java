package com.glodon.num01.exercise;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化工具类
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class SerializeUtil {

	/**
	 * 序列化
	 * 
	 * @param object
	 * @return
	 */
	public static <T> byte[] serialize(T obj) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			
			// 序列化对象
			oos.writeObject(obj);
			// 输出流转换为字节数组
			byte[] bytes = baos.toByteArray();

			oos.flush();

			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	/**
	 * 反序列化
	 * 
	 * @param bytes
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(byte[] bytes, Class<T> clazz) {
		ByteArrayInputStream bais = null;
		
		try {
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			
			return (T) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bais!=null) {
				try {
					bais.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

}
