package com.xx.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author xiaoxinga
 * @date 2020/06/29 13:55
 * @since
 */
public class PartitionTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "106.12.60.7:9092");
        properties.put("partitioner.class","com.xx.producer.config.MyPartitioner");
        Producer<String, String> producer = new KafkaProducer<String, String>(properties, new StringSerializer(),
                new StringSerializer());
        ProducerRecord noKeyRecord = new ProducerRecord<>("test-topic", "no-key-record");
        ProducerRecord auditRecord = new ProducerRecord<>("test-topic", "audit", "audit-record");
        ProducerRecord otherRecord = new ProducerRecord<>("test-topic", "other","other-record");
        producer.send(noKeyRecord).get();
        producer.send(otherRecord).get();
        producer.send(auditRecord).get();
        producer.send(noKeyRecord).get();
        producer.send(otherRecord).get();
    }
}
