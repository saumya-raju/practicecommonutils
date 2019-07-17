package com.wipro.digital.application.producer.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Test {
	
	public static void main(String[] args) throws Exception {
	
		Map<String, Class<?>> props = new HashMap<String, Class<?>>();
		props.put("foo", Integer.class);
		props.put("bar", String.class);
	
		Class<?> clazz = PojoGenerator.generate(
				"com.wipro.digital.application.producer.util.Pojo$Generated", props);
	
		Object obj = clazz.newInstance();
	
		System.out.println("Clazz: " + clazz);
		System.out.println("Object: " + obj);
		System.out.println("Serializable? " + (obj instanceof Serializable));
	
		for (final java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
			System.out.println(method);
		}
	
		// set property "bar"
		clazz.getMethod("setBar", String.class).invoke(obj, "Hello World!");
	
		// get property "bar"
		String result = (String) clazz.getMethod("getBar").invoke(obj);
		System.out.println("Value for bar: " + result);
	
	}
}

