package com.skk8s.base;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;

/**
 * @author sukang
 */
public class KafkaSendResult extends SendResult<String, Object> {



    private Boolean successed;




    public KafkaSendResult(ProducerRecord<String, Object> producerRecord, RecordMetadata recordMetadata) {
        super(producerRecord, recordMetadata);
        if (producerRecord != null && recordMetadata != null){
            this.setSuccessed(true);
        }
    }



    public static KafkaSendResult build(SendResult<String, Object> sendResult) {
        if (sendResult == null){
            KafkaSendResult kafkaSendResult = new KafkaSendResult(null,null);
            kafkaSendResult.setSuccessed(false);
            return kafkaSendResult;

        }
        return new KafkaSendResult(sendResult.getProducerRecord(), sendResult.getRecordMetadata());
    }

    public Boolean getSuccessed() {
        return successed;
    }

    public void setSuccessed(Boolean successed) {
        this.successed = successed;
    }

}
