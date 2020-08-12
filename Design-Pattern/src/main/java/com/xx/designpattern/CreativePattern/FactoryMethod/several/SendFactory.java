package com.xx.designpattern.CreativePattern.FactoryMethod.several;

import com.xx.designpattern.CreativePattern.FactoryMethod.MailSender;
import com.xx.designpattern.CreativePattern.FactoryMethod.Sender;
import com.xx.designpattern.CreativePattern.FactoryMethod.SmsSender;

/**
 * 多个工厂方法模式
 *
 * @author xiaoxinga
 * @date 2020/06/05 11:12
 * @since
 */
public class SendFactory {
    public Sender produceMail() {
        return new MailSender();
    }

    public Sender produceSms() {
        return new SmsSender();
    }

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMail();
        sender.send();
    }
}
