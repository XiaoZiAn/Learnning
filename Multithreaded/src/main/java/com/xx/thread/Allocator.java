package com.xx.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoxinga
 * @date 2020/05/22 10:08
 * @since
 */
public class Allocator {
    private List als = new ArrayList<>();

    // 一次性申请所有资源
    synchronized boolean apply(Object from, Object to) {
        if (als.contains(from) || als.contains(to)) {
            return false;
        } else {
            als.add(from);
            als.add(to);
        }
        return true;
    }

    // 归还资源
    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
    }

    // 使用wait释放当前持有的锁，避免死锁
    synchronized boolean apply1(Object from, Object to) {
        if (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (Exception e) {
            }
        } else {
            als.add(from);
            als.add(to);
        }
        return true;
    }

    // 释放锁，唤醒其他正在等待线程
    synchronized void free1(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }
}
