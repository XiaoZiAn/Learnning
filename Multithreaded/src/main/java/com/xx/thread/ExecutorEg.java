package com.xx.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author xiaoxinga
 * @date 2020/05/19 16:48
 * @since
 */
public class ExecutorEg {
    private static final Executor exec = Executors.newFixedThreadPool(30);

    public static void main(String[] args) {
        while (true){
            Runnable task = () -> System.out.println(Math.random());
            exec.execute(task);
        }
    }
}
