package com.sk.netty;

import com.sk.netty.utils.HexUtils;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: sukang  银联16进制 输入 报文测试类
 * @Date: 2021/6/24 20:55
 */
public class HexBodyTest {



    @Test
    public void hexTest() throws Exception{
        byte[] bytes = Hex.decodeHex("30353230");

        System.out.println(bytes);
    }


    @Test
    public void parseHexStr() throws Exception {

        int index = 0;

        String hex = "303532302e02303532303033303330303030202020303030313030303020202041410000303030303030303000303030303030323030e23a46c1a8e09a120000000010000081313636323531393335313031303130343239333030303030303931393131343533303030313930323131343533303039313930373139363031313035313030313032303630383932303130303030303839323031303030303239363236363636363636363636363635323d3330313032303130303030303030303030303030303030373132333435363738313233343536373839303132333435d6d0b9fad2f8c1aa4348494e4120554e494f4e5041592053494d554c41544f5220202020202020203135360000000000000000323430303030303030303030303030303131325f2a02015682027d00950500001800009a032309199c01019f02060000000100009f03060000000000009f100807010103a0b806019f1a0201569f1e0832303033313233309f260818746af856e1adb79f2701809f3303e098c09f34036003029f3501229f360219039f37040b7fbd48303237303030303036303030313030303030303030303034303232303030303231534d3031361b288ab423f387e00141c799e07a136c30383033303330303030303433353143533232303030303034353033313030303030202020303030303030303030303030303030303030303842324630393146";
        //前4个字节表示总长度
        System.out.println(hex.length() / 2 - 4);
        System.out.println("总长度为 " + HexUtils.hexToAscii(hex.substring(0, (index = 4 * 2))));


        System.out.println("报文头长度46个字节,值为 " + hex.substring(index, index = (index + 46 * 2)));


        System.out.println("mti的长度为4个字节, 值为 " + HexUtils.hexToAscii(hex.substring(index, (index = (index + 4 * 2)))));


        String bigMap = "";
        System.out.println("位图长度为8个字节, 二进制值为 " + (bigMap = toBinaryString(hex.substring(index, (index = index + 8 * 2)))));


        AtomicInteger atomicInteger = new AtomicInteger(1);
        List<Object> list = new ArrayList<>();
        char[] charArray = bigMap.toCharArray();

        for (char c : charArray) {
            if ((int)c == 32){
                continue;
            }
            if (c == '1') {
                list.add(atomicInteger.get());
            }
            atomicInteger.getAndIncrement();
        }

        System.out.println("位图的值为 "+ list);


        System.out.println("body体的数据为 " + hex.substring(index));







        System.out.println(index);

    }


    /**
     *变长会带有长度信息, 定长不会带长度信息
     */
    private Map<String, String> parseBody(String hex){
        Map<String, String> map = new HashMap<>();

        return map;
    }



    private static String toBinaryString(String hexStr){

        System.out.println(hexStr);
        StringBuilder stringBuilder = new StringBuilder();

        int indexEnd = hexStr.length() / 2;

        for (int i = 0; i < indexEnd; i++) {
            String substring = hexStr.substring(i * 2, (i + 1) * 2);
            stringBuilder.append(org.apache.commons.lang3.StringUtils.leftPad(Integer.toBinaryString(Integer.parseInt(substring, 16)),   8 ,"0"));
            stringBuilder.append("  ");
        }

        return stringBuilder.toString();
    }

}
