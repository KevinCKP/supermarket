package com.scau.kevin.supermarket.redis;

/**
 * @Author: kevin
 * @Date: 2019/1/5 21:49
 * @Version 1.0
 */
public class ProfitKey extends BasePrefix{
    private static final int PROFIT_EXPIRE = 3600 * 24 * 30;


    public ProfitKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public ProfitKey(String prefix) {
        super(prefix);
    }
}
