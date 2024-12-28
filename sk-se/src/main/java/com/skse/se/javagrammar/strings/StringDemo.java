package com.skse.se.javagrammar.strings;


import org.junit.Test;


class B implements Cloneable{
	private String age ;
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getAge() {
		return age;
	}
}

class A implements Cloneable{
	private String name;
	
	private B b;
	
	@Override
	public Object clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return object;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
}

public class StringDemo {
	
	private String string;
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		// fromIndex >= sourceCount

		System.out.println("jghj".substring(2));

	}
	
	
	
	
	
	
	
	
	@Test
	public void main7(){
		/*Random random = ThreadLocalRandom.current();
		System.out.println(random.nextInt(5));*/
		
		byte b = -3;
		System.out.println(Integer.toHexString((int)b & 0xff));
	}
	
	
	
	@Test
	public void main5(){
		String s2 = new String("java");
		String s1 = "java";
		String s3 = "java";
		System.out.println(s1 == s3);  //true
		System.out.println(s1.equals(s2));  //true
		System.out.println(s2 == s3);
		
	}
	
	@Test
	public void main10(){

		String str1 = "abc";
		String s1 = "ab";
		String s2 = s1 + "c";//杩愯鏈� 褰撲綔string瀵硅薄澶勭悊
		String s3 = "ab" + "c";//缂栬瘧鏈熺洿鎺ユ斁鍏ュ父閲忔睜
		String str2 = new String("abc").intern();
		String str3 = new String("abc");
		
		
		//t
		System.out.println(s3 == str1);
		
		//f
		System.out.println(str1 == s2);
		
		//t
		System.out.println(str1 == s2.intern());

		//t
		System.out.println(str1 == str2);
		
		//f
		System.out.println(str1 == str3);
		
		//f
		System.out.println(str2 == str3);
		
	}
	
	
	
	
	
	
	
	@Test
	public void main6(){
		System.out.println(-119 & 0xff);
		System.out.println(Integer.toHexString(-119 & 0xff));
	}
	

	public String getString() {
		return string;
	}
	
	@Test
	public void main1(){
		/*byte b = -119;
		System.out.println((int)b);
		
		System.out.println(Integer.toHexString((int)b));
		System.out.println(Integer.toHexString(b & 0xff));*/
		
		String string  = "1";
		
		System.out.println(Integer.parseInt(string));

	}

	public void setString(String string) {
		this.string = string;
	}
	
	
	
	
	
	
	
	
	
	

}
