package com.xx.producer.config;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author xiaoxinga
 * @date 2020/06/29 14:10
 * @since
 */
public class MyPartitioner implements Partitioner {
    private Random random;

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        String keyValue = (String) key;
        List<PartitionInfo> partitionInfos = cluster.availablePartitionsForTopic(topic);
        int partitionCount = partitionInfos.size();
        int auditPartition = partitionCount - 1;
        return keyValue == null || keyValue.isEmpty() || !((String) key).contains("audit") ?
                random.nextInt(partitionCount - 1)
                : auditPartition;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {
        random = new Random();
    }
}
