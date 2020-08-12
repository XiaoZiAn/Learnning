package com.xx.producer.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author xiaoxinga
 * @date 2020/06/29 17:19
 * @since
 */
public class CountInterceptor implements ProducerInterceptor {
    private int errorCount = 0;
    private int successCount = 0;

    @Override
    public ProducerRecord onSend(ProducerRecord record) {
        return record;
    }

    // 记录发送消息成功和失败的次数
    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        if (exception == null) {
            successCount++;
        } else {
            errorCount++;
        }
    }

    @Override
    public void close() {
        System.out.println("Success count:" + successCount);
        System.out.println("Error count:" + errorCount);
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
