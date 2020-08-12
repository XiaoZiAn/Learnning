package com.xx.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author xiaoxinga
 * @date 2020/06/29 17:24
 * @since
 */
public class InterrceptorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "106.12.60.7:9092");
        List<String> interceptors = new ArrayList<>();
        interceptors.add("com.xx.producer.interceptor.CountInterceptor");
        interceptors.add("com.xx.producer.interceptor.TimeInterceptor");
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);
        Producer<String, String> producer = new KafkaProducer<String, String>(properties, new StringSerializer(),
                new StringSerializer());
        for (int i = 0; i < 5; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("test-topic", "message" + Integer.toString(i));
            System.out.println(producer.send(record).get());
        }

        producer.close();
    }
}
