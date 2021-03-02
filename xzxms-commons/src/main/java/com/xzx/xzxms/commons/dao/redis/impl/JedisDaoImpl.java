package com.xzx.xzxms.commons.dao.redis.impl;


import com.xzx.xzxms.commons.dao.redis.JedisDao;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Repository
public class JedisDaoImpl implements JedisDao {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean exists(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    @Override
    public boolean del(String key) {
        if (exists(key)) {
            return stringRedisTemplate.delete(key);
        }
        return false;
    }

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void setCode(String key, String value, long minutes) {
        stringRedisTemplate.opsForValue().set(key, value, minutes, TimeUnit.MINUTES);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
    
}
