package com.xx.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

/**
 * @author xiaoxinga
 * @date 2020/06/30 11:09
 * @since
 */
public class ConsumerTest {
    public static void main(String[] args) {
        String topicName = "test-topic";
        String groupId = "test-group";
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "106.12.60.7:9092");
        properties.put("group.id", groupId);
        properties.put("auto.offset.reset", "earliest");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties, new StringDeserializer()
                , new StringDeserializer());
        consumer.subscribe(Collections.singletonList(topicName));
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("offset:" + record.offset() + ",key:" + record.key() + ",value:" + record.value());
                }
            }
        } finally {
            consumer.close();
        }
    }
}
