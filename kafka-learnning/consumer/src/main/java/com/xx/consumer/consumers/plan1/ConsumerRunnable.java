package com.xx.consumer.consumers.plan1;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

/**
 * 消费者runnable类
 * @author xiaoxinga
 * @date 2020/07/01 14:08
 * @since
 */
public class ConsumerRunnable implements Runnable {
    private final KafkaConsumer<String, String> consumer;

    public ConsumerRunnable(String brokerList, String groupId, String topic) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", brokerList);
        properties.put("group.id", groupId);
        properties.put("auto.offset.reset", "earliest");
        this.consumer = new KafkaConsumer<String, String>(properties, new StringDeserializer()
                , new StringDeserializer());
        consumer.subscribe(Collections.singletonList(topic));
    }

    @Override
    public void run() {
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(2000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("offset:" + record.offset() + ",key:" + record.key() + ",value:" + record.value());
            }
        }
    }
}
