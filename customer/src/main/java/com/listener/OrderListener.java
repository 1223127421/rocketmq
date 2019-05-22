package com.listener;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: wangzhuyi
 * @Date: 2019/5/22 15:57
 * @Version 1.0
 * @Describe
 */
@Component
public class OrderListener implements MessageListenerConcurrently {

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        for (MessageExt msg : msgs) {
            System.out.println("消费者监听到的消息：" + msg.getBody());
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
