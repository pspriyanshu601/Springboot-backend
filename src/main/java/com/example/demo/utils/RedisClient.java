package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisClient {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //set data into redis with key and value and expire time with exception handling Take 3 parameters key, value and expireTime and timeunit

    public void setData(String key, Object value, Long expireTime, TimeUnit timeUnit) {
        try {
            redisTemplate.opsForValue().set(key, value,expireTime, timeUnit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //get data from redis with key with exception handling
    public Object get(String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //delete data from redis with key with exception handling

    public void delete(String key) {
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
