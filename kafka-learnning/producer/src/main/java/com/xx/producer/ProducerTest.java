package com.xx.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author xiaoxinga
 * @date 2020/06/29 9:36
 * @since
 */
public class ProducerTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "106.12.60.7:9092");
        Producer<String, String> producer = new KafkaProducer<String, String>(properties, new StringSerializer(),
                new StringSerializer());
        for (int i = 0; i < 5; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("my-topic", Integer.toString(i));
            System.out.println(producer.send(record).get());
            // 异步发送
            /*producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    // metadata和exception只会存在一个有值
                    if (exception == null) {
                        // 消息发送成功
                        System.out.println("发送成功" + metadata);
                    } else {
                        // 消息发送失败
                        System.out.println("发送失败" + exception);
                    }
                }
            });*/
        }

        producer.close();
    }
}
