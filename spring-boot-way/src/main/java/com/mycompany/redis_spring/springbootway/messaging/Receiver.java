/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.redis_spring.springbootway.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Simple POJO
 */
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch countDownLatch;

    @Autowired
    public Receiver(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void receiveMessage(String message) {
        LOGGER.info("Received <{}>", message);
        countDownLatch.countDown();
    }
}
