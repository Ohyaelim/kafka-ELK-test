package com.kafkaelk.oyltest.Log;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TimeBomb {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    AtomicInteger count = new AtomicInteger(1);

    @Scheduled(fixedDelay = 1000L)
    void wait10SecondsExitApplication(){
        logger.error("샘플 에러 메세지 "+count.getAndIncrement());

        try {
            logger.info("Will exit in 10");
            Thread.sleep(10000);
        }catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }finally {
            logger.info("application 닫기");
            System.exit(0);
        }
    }
}
