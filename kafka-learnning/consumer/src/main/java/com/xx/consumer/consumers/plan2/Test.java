package com.xx.consumer.consumers.plan2;

/**
 * @author xiaoxinga
 * @date 2020/07/01 15:51
 * @since
 */
public class Test {
    public static void main(String[] args) {
        final ConsumerThreadHandler<byte[], byte[]> handler = new ConsumerThreadHandler<>("106.12.60.7:9092"
                , "test-group", "test-topic");
        final int cpuCount = Runtime.getRuntime().availableProcessors();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                handler.consume(cpuCount);
            }
        };

        new Thread(runnable).start();

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {

        }

        System.out.println("Starting to close the consumer...");
        handler.close();
    }
}
