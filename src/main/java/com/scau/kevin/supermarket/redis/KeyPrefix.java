package com.scau.kevin.supermarket.redis;

/**
 * @Author: kevin
 * @Date: 2019/1/5 21:44
 * @Version 1.0
 */
public interface KeyPrefix {
    int expireSeconds();
    String getPrefix();
}
