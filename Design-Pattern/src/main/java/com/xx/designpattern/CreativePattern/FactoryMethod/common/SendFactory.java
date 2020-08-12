package com.xx.designpattern.CreativePattern.FactoryMethod.common;

import com.xx.designpattern.CreativePattern.FactoryMethod.MailSender;
import com.xx.designpattern.CreativePattern.FactoryMethod.Sender;
import com.xx.designpattern.CreativePattern.FactoryMethod.SmsSender;

/**
 * 普通工厂方法模式
 *
 * @author xiaoxinga
 * @date 2020/06/05 11:09
 * @since
 */
public class SendFactory {
    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.send();
    }
}
