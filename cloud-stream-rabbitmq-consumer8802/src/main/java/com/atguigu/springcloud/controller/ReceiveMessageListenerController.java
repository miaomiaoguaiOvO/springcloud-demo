package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author Fan
 * @Date 2020/7/25
 * @Description:
 */
@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者1号，接收到的消息："+message.getPayload()+"\t  端口号："+serverPort);
//        return "消费者1号，接收到的消息："+message.getPayload()+"\t  端口号："+serverPort;
    }

}
