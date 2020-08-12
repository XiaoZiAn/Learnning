package com.xx.designpattern.CreativePattern.AbstractFactory;

import com.xx.designpattern.CreativePattern.FactoryMethod.MailSender;
import com.xx.designpattern.CreativePattern.FactoryMethod.Sender;

/**
 * @author xiaoxinga
 * @date 2020/06/05 11:26
 * @since
 */
public class SendMailFactory implements Provider {

    @Override
    public Sender produce() {
        return new MailSender();
    }

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
