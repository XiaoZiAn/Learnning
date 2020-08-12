package com.xx.designpattern.CreativePattern.AbstractFactory;

import com.xx.designpattern.CreativePattern.FactoryMethod.Sender;

/**
 * @author xiaoxinga
 * @date 2020/06/05 11:25
 * @since
 */
public interface Provider {
    public Sender produce();
}
