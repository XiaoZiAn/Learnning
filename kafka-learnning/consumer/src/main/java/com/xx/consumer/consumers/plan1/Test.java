package com.xx.consumer.consumers.plan1;

/**
 * @author xiaoxinga
 * @date 2020/07/01 14:26
 * @since
 */
public class Test {
    public static void main(String[] args) {
        ConsumerGroup group = new ConsumerGroup(3, "106.12.60.7:9092", "test-group", "test-topic");
        group.execute();
    }
}