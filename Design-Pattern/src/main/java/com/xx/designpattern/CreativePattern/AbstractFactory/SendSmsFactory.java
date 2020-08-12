package com.xx.designpattern.CreativePattern.AbstractFactory;

import com.xx.designpattern.CreativePattern.FactoryMethod.Sender;
import com.xx.designpattern.CreativePattern.FactoryMethod.SmsSender;

/**
 * @author xiaoxinga
 * @date 2020/06/05 11:27
 * @since
 */
public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
