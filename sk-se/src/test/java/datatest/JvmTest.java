package datatest;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JvmTest {
	
	private  int i = 0;


	@Test
	public void main4(){

		int compareTo = LocalDate.of(2021, 1, 1).compareTo(LocalDate.of(2021, 1, 2));

		System.out.println(compareTo);

	}
	
	
	
	
	@Test
	public void main3(){
		ClassLoader contextClassLoader = Thread.currentThread()
				.getContextClassLoader();
		System.out.println(contextClassLoader);
		
		ClassLoader classLoader = getClass().getClassLoader();
		System.out.println(classLoader);
		
	}
	
	
	
	/**
	 * intern() 方法返回字符串对象的规范化表示形式
	 * 如果存在直接获取，如果不存在就创建一个
	 * @throws Exception 
	 */
	@Test
	public void main2() throws Exception{
		
	   try {  
	       List<String> strings = new ArrayList<String>();  
	       int i = 0;  
	       while(true){  
	          strings.add(String.valueOf(i++).intern());  
	       }  
	   } catch (Exception e) {  
	       e.printStackTrace();  
	       throw e;  
	   }  
	}
	
	
	
	
	/**
	 * java栈内存溢出
	 * java.lang.StackOverflowError
	 */
	@Test
	public void add(){
		
		System.out.println(++i);
		add();
	}
}
