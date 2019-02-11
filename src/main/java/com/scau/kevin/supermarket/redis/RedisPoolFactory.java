package com.scau.kevin.supermarket.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: kevin
 * @Date: 2019/1/5 21:57
 * @Version 1.0
 */
@Service
public class RedisPoolFactory {
    @Autowired
    private RedisConfig redisConfig;
    @Bean(name = "jedisPool")
    public JedisPool jedisPoolFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        jedisPoolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        jedisPoolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
        JedisPool jp = new JedisPool(jedisPoolConfig,redisConfig.getHost(),redisConfig.getPort(),
                                     redisConfig.getTimeout() * 1000,redisConfig.getPassword());
        return jp;
    }
}
