package com.xx.producer.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author xiaoxinga
 * @date 2020/06/29 17:16
 * @since
 */
public class TimeInterceptor implements ProducerInterceptor {
    // 在生产者向kafka发消息前，在value加上时间戳
    @Override
    public ProducerRecord onSend(ProducerRecord record) {
        return new ProducerRecord<>(record.topic(), record.key(),
                System.currentTimeMillis() + " " + record.value().toString());
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
