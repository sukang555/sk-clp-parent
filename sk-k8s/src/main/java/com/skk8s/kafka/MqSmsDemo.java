package com.skk8s.kafka;


import com.skk8s.base.KafkaSendResult;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;



/**
 * @author sukang
 */
@ManagedBean
public class MqSmsDemo extends KafkaProducer {

    @Resource
    private KafkaTemplate<String, Object> msgKafkaTemplate;

    final String topic = "MQ_SYS_DMEO";



    public void sendMsgToSysDemoSync(String key, String value){

        KafkaSendResult kafkaSendResult = sendMessage(msgKafkaTemplate, topic, key, value);

        System.out.println(kafkaSendResult.getSuccessed());

    }



    public void sendMsgToSysDemoAsync(String key, String value){

        sendMessageWithOutResult(msgKafkaTemplate, topic, key, value);
        //ignore result
    }


}










































