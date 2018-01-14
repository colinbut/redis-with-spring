/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.redis_spring.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //region cache capabilities - storing & retrieving key-value pairs
    public Object getValue(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void setValue(final String key, final String value) {
        redisTemplate.opsForValue().set(key, value);

        // TTL expiry
        redisTemplate.expire(key, 3, TimeUnit.MINUTES); // expire after 3 minutes
    }
    //endregion


}
