package com.skk8s.kafka;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Map;

/**
 * @author sukang
 */
public class KafkaConfig {


    public KafkaTemplate<String, Object> getKafkaTemplate(Map<String, Object> configMap){
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(configMap));
    }

}
