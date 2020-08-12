package com.xx.designpattern.CreativePattern.FactoryMethod;

/**
 * @author xiaoxinga
 * @date 2020/06/05 11:07
 * @since
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("This is smsSender!");
    }
}
