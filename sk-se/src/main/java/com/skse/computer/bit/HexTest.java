package com.skse.computer.bit;
import org.junit.Test;

/**
 * @author sukang
 */
public class HexTest {



	@Test
	public void main3(){
		String gbk2String = SBH.hexGBK2String("4DCFF9762A6CD3E12DC0A1E3A8D088767744B852004E093134384C60718580C3");

		System.out.println(gbk2String);

		System.out.println(SBH.string2HexGBK(gbk2String));
	}




   private static String charToHex(String source){
	   StringBuilder stringBuilder = new StringBuilder();
	   char[] chars = source.toCharArray();
	   for (char aChar : chars) {
		   stringBuilder.append(Integer.toHexString(aChar).toUpperCase());
	   }
	   return stringBuilder.toString();
   }






	private  String tenToChar(byte[] bytes){
		// 将10进制数字转为ascii 码值字符
		return new String(bytes);
	}


	private static byte[] transToBytes(String sourceStr) {
		int indexEnd = sourceStr.length()/2;
		byte[] bytes = new byte[indexEnd];

		for (int i = 0; i < indexEnd; i++) {
			String substring = sourceStr.substring(i * 2, (i + 1) * 2);

			int integer = Integer.parseInt(substring, 16);

			bytes[i] = (byte)(integer < 0 ? (integer + 256) : integer);
		}

		return bytes;
	}


	private static String transtoHexStr(){
		return String.format("%08X",8);
	}





	
	

}
