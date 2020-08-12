package com.xx.thread;

import java.io.IOException;

/**
 * @author xiaoxinga
 * @date 2020/05/19 16:32
 * @since
 */
public class ThreadEg {
    public static void main(String[] args) {
        while (true){
            Runnable task = () -> System.out.println(Math.random());
            new Thread(task).start();
        }
    }
}
