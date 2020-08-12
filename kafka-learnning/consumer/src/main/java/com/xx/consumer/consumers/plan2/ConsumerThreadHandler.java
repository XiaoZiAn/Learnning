package com.xx.consumer.consumers.plan2;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaoxinga
 * @date 2020/07/01 15:10
 * @since
 */
public class ConsumerThreadHandler<K, V> {
    private final KafkaConsumer<K, V> consumer;
    private ExecutorService executors;
    private final Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();

    public ConsumerThreadHandler(String brokerList, String groupId, String topic) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", brokerList);
        properties.put("group.id", groupId);
        properties.put("enable.auto.commit", "false");
        properties.put("auto.offset.reset", "earliest");
        this.consumer = new KafkaConsumer(properties, new StringDeserializer(), new StringDeserializer());
        consumer.subscribe(Collections.singletonList(topic), new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
                consumer.commitSync(offsets);
            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
                offsets.clear();
            }
        });
    }

    public void consume(int threadNum) {
        executors = new ThreadPoolExecutor(threadNum, threadNum, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(1000),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            ConsumerRecords<K,V> records = consumer.poll(1000L);
            if(!records.isEmpty()){
                executors.submit(new ConsumerWorker<>(records,offsets));
            }
            commitOffsets();
        } catch (WakeupException e){

        }finally {
            commitOffsets();
            consumer.close();
        }
    }

    private void commitOffsets(){
        Map<TopicPartition,OffsetAndMetadata> map;
        synchronized (offsets){
            if(offsets.isEmpty()){
                return;
            }
            map = Collections.unmodifiableMap(new HashMap<>(offsets));
            offsets.clear();
        }
        consumer.commitSync(map);
    }

    public void close(){
        consumer.close();
        executors.shutdown();
    }
}
