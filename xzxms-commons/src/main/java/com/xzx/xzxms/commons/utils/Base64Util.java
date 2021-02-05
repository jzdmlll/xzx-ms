package com.xzx.xzxms.commons.utils;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Base64Util {
    // 加密
    public static String encode(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = Base64.encodeBase64String(b);
        }
        return s;
    }

    // 解密
    public static String decode(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            try {
                b = Base64.decodeBase64(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static byte[] decodeImg(String imgStr) {
        byte[] b = null;
//        if (!StringUtils.isEmpty(imgStr)) {
//            return b;
//        }
        try {
            b = Base64.decodeBase64(imgStr);
            for (int i = 0; i < b.length; i++) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public static String encodeBase64File(InputStream inputStream){
        // 读取文件
        // 声明输入流
        // 声明字节数组
        byte[] buffer = null;
        try {
            // 创建字节数组
            buffer = new byte[inputStream.available()];
            // 输入
            inputStream.read(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 编码
        return new BASE64Encoder()
                .encode(buffer);
    }

    public static InputStream decodeBase64File(String base64Code) {
        InputStream inputStream = null;
        // 将base 64 转为字节数字
        byte[] buffer = new byte[0];

        try {
            buffer = new BASE64Decoder().decodeBuffer(base64Code);
            inputStream = new ByteArrayInputStream(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStream!=null)
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return inputStream;
    }

}
