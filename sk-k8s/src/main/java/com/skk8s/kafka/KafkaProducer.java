package com.skk8s.kafka;

import com.skk8s.base.KafkaSendResult;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.TimeUnit;

/**
 * @author sukang
 */
public class KafkaProducer {


    protected void sendMessageWithOutResult(KafkaTemplate<String,Object> kafkaTemplate,
                                         String topic,
                                         String key,
                                         String value){

        kafkaTemplate.send(topic, key, value);
    }



    protected KafkaSendResult sendMessage(KafkaTemplate<String,Object> kafkaTemplate,
                                          String topic,
                                          String key,
                                          String value){

        ListenableFuture<SendResult<String, Object>> sendResultListenableFuture = kafkaTemplate.send(topic, key, value);
        SendResult<String, Object> sendResult = null;

        try {
            sendResult = sendResultListenableFuture.get(1000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return KafkaSendResult.build(sendResult);
    }

}
