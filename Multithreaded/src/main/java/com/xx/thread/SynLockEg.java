package com.xx.thread;

/**
 * @author xiaoxinga
 * @date 2020/05/21 15:05
 * @since
 */
public class SynLockEg {
    static long a = 0;

    /**
     * synchronized 加锁实例this，即synchronized(this)
     *
     * @return
     */
    public synchronized long get() {
        return a;
    }

    /**
     * synchronized 加锁对象SynLockEg，即synchronized(SynLockEg.class)
     *
     * @return
     */
    public synchronized void add() {
        a += a;
    }
}
