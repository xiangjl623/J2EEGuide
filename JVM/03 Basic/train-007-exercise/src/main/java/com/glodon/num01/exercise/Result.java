package com.glodon.num01.exercise;

/**
 * 结果类（泛型）
 * 
 * @author fucy
 * @date 2020年7月26日
 * @since JDK1.8
 */
public class Result<T> {

	private T obj;
	
	public Result(T obj) {
		this.obj = obj;
	}
	
	public Result(byte[] bytes, Class<T> clazz) {
		this.obj = SerializeUtil.deserialize(bytes, clazz);
	}
	
	public byte[] getBytes() {
		return SerializeUtil.serialize(obj);
	}

	@Override
	public String toString() {
		return "Result [obj=" + obj + "]";
	}
	
}
