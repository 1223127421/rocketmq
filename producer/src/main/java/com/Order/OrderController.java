package com.Order;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangzhuyi
 * @Date: 2019/5/22 15:42
 * @Version 1.0
 * @Describe
 */
@RestController
@RequestMapping
public class OrderController {

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @GetMapping("send")
    public String send() throws Exception {
        String msg = "生产者发送消息";
        Message message = new Message("topic", "taga", msg.getBytes("UTF-8"));
        defaultMQProducer.send(message);
        return msg;
    }
}
