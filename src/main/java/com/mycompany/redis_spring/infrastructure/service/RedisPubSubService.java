/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.redis_spring.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class RedisPubSubService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void publish(final String message){
        redisTemplate.execute((RedisCallback<Long>) redisConnection -> redisConnection.publish(
            ((RedisSerializer<String>)redisTemplate.getKeySerializer()).serialize("queue"),
            ((RedisSerializer<String>)redisTemplate.getValueSerializer()).serialize(message)));
    }
}
