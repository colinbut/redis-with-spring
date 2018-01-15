/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.redis_spring.infrastructure.service;

import com.mycompany.redis_spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
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


    //region storing arbitrary objects as hashes (maps)
    public void setUser(final User user){
        final String key = String.format("user:%s", user.getUserId());
        final Map<String, Object> properties = new HashMap<>();

        properties.put("userId", user.getUserId());
        properties.put("name", user.getName());
        properties.put("email", user.getEmail());

        redisTemplate.opsForHash().putAll(key, properties);
    }

    public User getUser(final Long id) {
        final String key = String.format("user:%s", id);

        final String name = (String) redisTemplate.opsForHash().get(key, "name");
        final String email = (String) redisTemplate.opsForHash().get(key, "email");

        return new User(id, name, email);
    }
    //endregion


}
