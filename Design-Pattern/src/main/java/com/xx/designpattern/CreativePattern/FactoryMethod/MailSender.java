package com.xx.designpattern.CreativePattern.FactoryMethod;

/**
 * @author xiaoxinga
 * @date 2020/06/05 11:05
 * @since
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("This is mialSnder!");
    }
}
