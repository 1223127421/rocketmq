package com.test;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @Author: wangzhuyi
 * @Date: 2019/5/22 11:50
 * @Version 1.0
 * @Describe 同步发送消息
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            //Topic  Tag  Message body
            Message msg = new Message("TopicTest", "TagA", ("生产者消息：" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(msg);
            System.out.println("生产者消息sout:"+ sendResult);
        }
        producer.shutdown();
    }
}

