package com.liupeng.until;

import java.security.MessageDigest;

public class Md5Util {
    /**
     * 接收一个明文密码, 返回加密以后的密文
     *
     * @param pwd
     * @return
     */
    public static String md5(String pwd) throws Exception {
        // 创建MessageDigest对象
        MessageDigest digest = MessageDigest.getInstance("MD5");
        // 对明文进行加密
        byte[] temp = digest.digest(pwd.getBytes());
        // 准备StringBuilder用于保存结果
        StringBuilder builder = new StringBuilder();
        // 遍历字节数组, 一个字节转换为长度为2的字符串
        for (byte b : temp) {
            // 去除负数
            String s = Integer.toHexString(b & 0xff);
            // 补零
            if(s.length() == 1) {
                builder.append(0);
            }
            builder.append(s);
        }
        return builder.toString();
    }

}
