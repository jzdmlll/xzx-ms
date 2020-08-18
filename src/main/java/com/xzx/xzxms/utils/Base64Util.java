package com.xzx.xzxms.utils;
import org.apache.commons.codec.binary.Base64;

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

}
