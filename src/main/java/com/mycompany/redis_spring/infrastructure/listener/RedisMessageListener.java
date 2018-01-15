/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.redis_spring.infrastructure.listener;

import org.apache.log4j.Logger;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisMessageListener implements MessageListener {

    private static Logger LOGGER = Logger.getLogger(RedisMessageListener.class);

    @Override
    public void onMessage(Message message, byte[] bytes) {
        LOGGER.info("Received by RedisMessageListener " + message.toString());
    }
}
