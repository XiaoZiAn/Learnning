package com.xx.thread;

/**
 * 账户类
 * @author xiaoxinga
 * @date 2020/05/21 16:11
 * @since
 */
public class Account {
    // 账户id
    private int id;
    // 多锁
    private Allocator actr;
    //余额锁
    private final Object baLock = new Object();
    // 余额
    private double balance;
    // 密码锁
    private final Object paLock = new Object();
    // 密码
    private String password;

    public void withdraw(double money){
        synchronized (baLock){
            if(this.balance>money) {
                this.balance = this.balance - money;
            }
        }
    }

    public double getBalance(){
        synchronized (baLock) {
            return this.balance;
        }
    }

    public void updatePassword(String password){
        synchronized (paLock){
            this.password = password;
        }
    }

    public String lookPassword(){
        synchronized (paLock) {
            return this.password;
        }
    }

    // 转账操作需同时锁住两个账户余额，需要采用粒度更大的锁，采用对象锁
    // 此方法会导致所有转账操作变为串行，可行性太差
    public void transfer0(Account target, int amt) {
        synchronized (Account.class) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }

    // 同时锁住两个账户，可能导致死锁
    public void transfer1(Account target, int amt) {
        synchronized (this) {
            synchronized (target) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }

    // 一次性同时锁住两个账户
    public void transfer2(Account target, int amt) {
        while (!actr.apply(this, target))
            ;
        try {
            synchronized (this) {
                synchronized (target) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } finally {
            actr.free(this, target);
        }
    }

    //根据账户序号排序，先锁定id小得账户再锁定id大的账户
    public void transfer3(Account target, int amt) {
        Account left = this;
        Account right = target;
        if (this.id > target.id) {
            left = target;
            right = this;
        }
        synchronized (left) {
            synchronized (right) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }

    // 一次性同时锁住两个账户
    public void transfer4(Account target, int amt) {
        while (!actr.apply1(this, target))
            ;
        try {
            synchronized (this) {
                synchronized (target) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } finally {
            actr.free1(this, target);
        }
    }
}
