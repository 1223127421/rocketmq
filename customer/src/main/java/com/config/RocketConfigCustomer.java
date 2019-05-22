package com.config;

import com.listener.OrderListener;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wangzhuyi
 * @Date: 2019/5/22 15:49
 * @Version 1.0
 * @Describe
 */
@Configuration
public class RocketConfigCustomer {

    @Value("${rocketmq.groupName}")
    private String groupName;
    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;

    @Autowired
    private OrderListener orderListener;

    @Bean
    public DefaultMQPushConsumer orderCustomer() throws Exception {
        return defaultMQPushConsumer("topic", orderListener);
    }

    public DefaultMQPushConsumer defaultMQPushConsumer(String topic, MessageListenerConcurrently listener) throws Exception {
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer(groupName);
        defaultMQPushConsumer.setNamesrvAddr(namesrvAddr);
        defaultMQPushConsumer.subscribe(topic, "*");
        defaultMQPushConsumer.registerMessageListener(listener);
        defaultMQPushConsumer.start();
        return defaultMQPushConsumer;

    }
}
