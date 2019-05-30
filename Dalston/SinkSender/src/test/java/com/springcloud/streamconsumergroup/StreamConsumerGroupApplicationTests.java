package com.springcloud.streamconsumergroup;

import com.springcloud.streamconsumergroup.rabbitmq.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamConsumerGroupApplicationTests {

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 5; i++) {
            sinkSender.timerMessageSource();
        }
        while (true){

        }
    }

}
