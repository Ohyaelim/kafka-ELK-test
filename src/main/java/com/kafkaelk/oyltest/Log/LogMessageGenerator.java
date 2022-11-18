package com.kafkaelk.oyltest.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LogMessageGenerator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    AtomicInteger count = new AtomicInteger(1);

    void logSomeStuff() {
        int index = count.getAndIncrement();
        logger.info("로그메세지 만들어짐 " + index);
    }

}
