/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.redis_spring.springbootway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Simple POJO
 */
public class Reciever {

    private static final Logger LOGGER = LoggerFactory.getLogger(Reciever.class);

    private CountDownLatch countDownLatch;

    @Autowired
    public Reciever(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void receiveMessage(String message) {
        LOGGER.info("Received <{}>", message);
        countDownLatch.countDown();
    }
}
