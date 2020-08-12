package com.xx.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xiaoxinga
 * @date 2020/06/01 15:24
 * @since
 */
public class Tea {
    public static void main(String[] args) {
        FutureTask<String> futureTask1 = new FutureTask<String>(new Callable<String>() {
        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            System.out.println("洗水壶完成");
            Thread.sleep(15000);
            System.out.println("烧开水成功");
            return "success";
        }
    });

    FutureTask<String> futureTask2 = new FutureTask<String>(new Callable<String>() {
        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            System.out.println("洗茶壶完成");
            Thread.sleep(1000);
            System.out.println("洗茶壶成功");
            Thread.sleep(1000);
            System.out.println("拿茶叶成功");
            return "success";
        }
    });

        Thread thread1 = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);
        System.out.println(new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
        thread1.start();
        thread2.start();
        try {
            String result1 = futureTask1.get();
            String result2 = futureTask2.get();
            if (result1.equals("success") && result2.equals("success")) {
                System.out.println("泡茶成功");
            } else {
                System.out.println("泡茶失败");
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("泡茶失败");
            e.printStackTrace();
        }
        System.out.println(new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
    }
}
