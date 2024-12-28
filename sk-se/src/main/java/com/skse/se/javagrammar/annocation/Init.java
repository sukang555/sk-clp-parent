package com.skse.se.javagrammar.annocation;



import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


@MyAnnocation(name = "hello",value = "world")
public class Init{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) throws Exception{
		
		Class<?> clazz = Init.class;
		MyAnnocation annotation = clazz.getAnnotation(MyAnnocation.class);
		if (annotation != null) {
			Method[] methods = clazz.getDeclaredMethods();
			
			for (Method method : methods) {
				//method.setAccessible(true);
				MethodAnnocation methodAnnocation = method.getAnnotation(MethodAnnocation.class);
				if (methodAnnocation != null) {
					HashMap<String, String> hashMap = new HashMap<>();
					method.invoke(clazz.newInstance(), hashMap);
					System.out.println(hashMap);
				}
			}
		}
		
	}
	
	@MethodAnnocation
	private void main1(Map<String, String> map){
		map.put("value", "hello");
		System.out.println("main1");  
		
		
		
	}
	@MethodAnnocation
	public void main3(Map<String, String> map){
		System.out.println("main3");
	}
	
}
