package com.skk8s.kafka;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sukang
 */
@Configuration
@ConfigurationProperties(prefix = "anytxn.kafka")
public class KafkaMsgClientConfig extends KafkaConfig {

    private Map<String, Object> msg;



    @Bean
    public KafkaTemplate<String, Object> msgKafkaTemplate(){
        Map<String, Object> configMap = this.msg.entrySet().stream().collect(Collectors.toMap(
                e -> e.getKey().replace("-", "."),
                Map.Entry::getValue,
                (k1, k2) -> k1,
                HashMap::new
        ));

        return getKafkaTemplate(configMap);
    }


    public Map<String, Object> getMsg() {
        return msg;
    }

    public void setMsg(Map<String, Object> msg) {
        this.msg = msg;
    }
}
