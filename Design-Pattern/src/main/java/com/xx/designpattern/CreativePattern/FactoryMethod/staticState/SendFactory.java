package com.xx.designpattern.CreativePattern.FactoryMethod.staticState;

import com.xx.designpattern.CreativePattern.FactoryMethod.MailSender;
import com.xx.designpattern.CreativePattern.FactoryMethod.Sender;
import com.xx.designpattern.CreativePattern.FactoryMethod.SmsSender;

/**
 * @author xiaoxinga
 * @date 2020/06/05 11:17
 * @since
 */
public class SendFactory {
    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }

    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.send();
    }
}
