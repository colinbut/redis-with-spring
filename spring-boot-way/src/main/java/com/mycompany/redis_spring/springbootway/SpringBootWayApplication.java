package com.mycompany.redis_spring.springbootway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class SpringBootWayApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootWayApplication.class);

	public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = SpringApplication.run(SpringBootWayApplication.class, args);

        StringRedisTemplate stringRedisTemplate = applicationContext.getBean(StringRedisTemplate.class);
        CountDownLatch countDownLatch = applicationContext.getBean(CountDownLatch.class);

        LOGGER.info("Sending message");

        stringRedisTemplate.convertAndSend("chat", "Hello from Redis!");

        countDownLatch.await();

        System.exit(0);
	}
}
