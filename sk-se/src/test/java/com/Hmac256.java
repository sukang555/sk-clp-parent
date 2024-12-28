package com;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author: sukang
 * @Date: 2022/11/4 13:02
 */
public class Hmac256 {



    public static void main(String[] args) throws Exception {

        String message = "1";
        String secret = "1";

        String hmacSHA256 = hmacSHA256(secret, message);


    }



    public static String hmacSHA256(String secret, String message) throws Exception {
        String hash = "";
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        hmacSha256.init(secret_key);
        byte[] bytes = hmacSha256.doFinal(message.getBytes());
        hash = byteArrayToHexString(bytes);
        return hash;
    }


    public  static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }


}
