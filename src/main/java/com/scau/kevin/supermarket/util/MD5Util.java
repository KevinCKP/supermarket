package com.scau.kevin.supermarket.util;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author: kevin
 * @Date: 2018/12/28 21:46
 * @Version 1.0
 */
public class MD5Util {
    public static String md5(String password){
        return DigestUtils.md5Hex(password);
    }

    public static void main(String[] args) {
        System.out.println(md5("123456"));
    }
}
