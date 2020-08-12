package com.xx.consumer.consumers.plan1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoxinga
 * @date 2020/07/01 14:20
 * @since
 */
public class ConsumerGroup {
    private List<ConsumerRunnable> consumers = new ArrayList<>();

    public ConsumerGroup(int consumerNum, String brokerList, String groupId, String topic) {
        for (int i = 0; i < consumerNum; i++)
            this.consumers.add(new ConsumerRunnable(brokerList, groupId, topic));
    }

    public void execute() {
        for (ConsumerRunnable consumer : this.consumers)
            new Thread(consumer).start();
    }
}
