package com.scau.kevin.supermarket.redis;

/**
 * @Author: kevin
 * @Date: 2019/1/5 21:45
 * @Version 1.0
 */
public abstract class BasePrefix implements KeyPrefix{
    private int expireSeconds; // 过期时间
    private String prefix;  // 前缀

    public BasePrefix(int expireSeconds,String prefix){
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }
    public BasePrefix(String prefix){
        this(0,prefix);
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
}
