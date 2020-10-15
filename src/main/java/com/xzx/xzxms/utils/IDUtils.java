package com.xzx.xzxms.utils;

import com.google.common.math.LongMath;

import java.util.Random;
import java.util.UUID;

/**
 * 各种id生成策略
 * @version 1.0
 */
public class IDUtils {

    /**
     * 图片名生成
     */
    public static String getImageName() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);
        //如果不足三位前面补0
        String str = millis + String.format("%03d", end3);
        return str;
    }

    /**
     * id生成
     */
    public static long oldGetId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();

        //long millis = System.nanoTime();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }

    public static Long getId(){
        Integer orderId=UUID.randomUUID().toString().hashCode();

        return Long.valueOf(Math.abs(orderId));
    }

}
