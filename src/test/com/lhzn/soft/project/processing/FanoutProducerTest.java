package com.lhzn.soft.project.processing;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@SpringBootTest
@RunWith(SpringRunner.class)
class FanoutProducerTest {
    @Resource
    private FanoutProducer fanoutProducer;

    @Test
    void selectBySessionId() {
        fanoutProducer.selectBySessionId();
    }
}