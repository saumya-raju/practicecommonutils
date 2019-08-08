package com.wipro.digital.application.producer.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;


public class Test {
	
	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * Map<String, Class<?>> props = new HashMap<String, Class<?>>();
	 * props.put("foo", Integer.class); props.put("bar", String.class);
	 * 
	 * Class<?> clazz = PojoGenerator.generate(
	 * "com.wipro.digital.application.producer.util.Demo", props);
	 * 
	 * Object obj = clazz.newInstance();
	 * 
	 * System.out.println("Clazz: " + clazz); System.out.println("Object: " + obj);
	 * System.out.println("Serializable? " + (obj instanceof Serializable));
	 * 
	 * for (final java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
	 * System.out.println(method); }
	 * 
	 * // set property "bar" clazz.getMethod("setBar", String.class).invoke(obj,
	 * "Hello World!");
	 * 
	 * // get property "bar" String result = (String)
	 * clazz.getMethod("getBar").invoke(obj);
	 * 
	 * 
	 * System.out.println("Value for bar: " + result);
	 * 
	 * }
	 */
	
	 /* Function checks if passed strings (str1 and str2) 
    are rotations of each other */
 static boolean areRotations(String str1, String str2) 
 { 
     // There lengths must be same and str2 must be  
     // a substring of str1 concatenated with str1.   
     return (str1.length() == str2.length()) && 
            ((str1 + str1).indexOf(str2) != -1); 
 } 
   
 // Driver method 
 public static void main (String[] args) 
 { 
     String str1 = "ABCD"; 
     String str2 = "CDAB"; 

     if (areRotations(str1, str2)) 
         System.out.println("Strings are rotations of each other"); 
     else
         System.out.printf("Strings are not rotations of each other"); 
 } 
}

