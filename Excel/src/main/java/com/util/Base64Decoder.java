package com.util;

import java.util.Base64;

/**
 * @Pragram:Base64Decoder
 * @Description:TODO 编码、解码
 * @Author:ZhuShiQiang
 * @Create:2020-06-18 10:26:33
 **/
public class Base64Decoder {
    final static Base64.Decoder decoder = Base64.getDecoder();
    final static Base64.Encoder encoder = Base64.getEncoder();

    //解码
    public static String decode(String encodeText){
        String decodeStr = null;
        try {
            byte[] decodeText = decoder.decode(encodeText);
            decodeStr = new String(decodeText, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decodeStr;
    }

    //编码
    public static String encode(String sourceStr){
        String encodeText = null;
        try {
            byte[] textBytes = sourceStr.getBytes("utf-8");
            encodeText = encoder.encodeToString(textBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return encodeText;
    }
}
