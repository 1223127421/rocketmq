package com.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wangzhuyi
 * @Date: 2019/5/22 15:30
 * @Version 1.0
 * @Describe
 */
@Configuration
public class RockerConfigProducer {

    @Value("${rocketmq.groupName}")
    private String groupName;
    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;

    @Bean
    public DefaultMQProducer defaultMQProducer() throws MQClientException {
        //生产者的组名
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer(groupName);
        //指定NameServer地址，多个地址以 ; 隔开
        defaultMQProducer.setNamesrvAddr(namesrvAddr);
        defaultMQProducer.setVipChannelEnabled(false);
        defaultMQProducer.setRetryTimesWhenSendFailed(10);
        defaultMQProducer.start();
        return defaultMQProducer;
    }
}
