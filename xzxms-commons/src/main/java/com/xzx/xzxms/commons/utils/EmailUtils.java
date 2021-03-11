package com.xzx.xzxms.commons.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmailUtils {
    // 随机验证码
    public static String achieveCode() {
        String[] beforeShuffle= new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(3, 9);
        // System.out.print(result);
        return result;
    }


    // 发送验证码
    public static String sendEamilCode(String email, String message) {
        HtmlEmail send = new HtmlEmail();
        // 获取随机验证码
        String resultCode = achieveCode();
        try {
            send.setHostName("smtp.exmail.qq.com");
            send.setSmtpPort(465);                                            //端口号
            send.setSSLOnConnect(true);                                   //开启SSL加密
            send.setCharset("utf-8");
            send.addTo(email);                                                  //接收者的QQEamil
            send.setFrom("lzc@smalllei.cn","新自信管理平台");          //第一个参数是发送者的QQEamil   第二个参数是发送者QQ昵称
            send.setAuthentication("lzc@smalllei.cn", "Jzdmlll@1217");  //第一个参数是发送者的QQEamil   第二个参数是刚刚获取的授权码
            send.setSubject("新自信管理平台|重置密码身份验证");            //Eamil的标题
            send.setMsg("【新自信管理平台】验证码："+resultCode+"(5分钟内有效)。该验证码用于"+message+"，请勿泄露该验证码。");   //Eamil的内容
            // 该验证码用于重置密码，请勿泄露该验证码。

            send.send();            //发送
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return resultCode;        //同等验证码
    }
	public static void main(String[] args) {
		EmailUtils email = new EmailUtils();

		email.sendEamilCode("1037617790@qq.com", "重置密码");
	}
}