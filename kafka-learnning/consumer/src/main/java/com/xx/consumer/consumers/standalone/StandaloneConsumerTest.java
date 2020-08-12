package com.xx.consumer.consumers.standalone;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * @author xiaoxinga
 * @date 2020/07/02 8:58
 * @since
 */
public class StandaloneConsumerTest {
    public static void main(String[] args) {
        String topicName = "test-topic";
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "106.12.60.7:9092");
        properties.put("auto.offset.reset", "earliest");
        properties.put("enable.auto.commit", "false");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties, new StringDeserializer()
                , new StringDeserializer());
        List<TopicPartition> partitions = new ArrayList<>();
        List<PartitionInfo> partitionInfos = consumer.partitionsFor("test-topic");
        if(partitionInfos!=null&&!partitionInfos.isEmpty()){
            for (PartitionInfo partitionInfo:partitionInfos){
                partitions.add(new TopicPartition(partitionInfo.topic(),partitionInfo.partition()));
            }
            consumer.assign(partitions);
        }
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("offset:" + record.offset() + ",key:" + record.key() + ",value:" + record.value());
                }
                consumer.commitSync();
            }
        } finally {
            consumer.commitSync();
            consumer.close();
        }
    }
}
