package com.xx.designpattern.CreativePattern.Builder;

import com.xx.designpattern.CreativePattern.FactoryMethod.MailSender;
import com.xx.designpattern.CreativePattern.FactoryMethod.Sender;
import com.xx.designpattern.CreativePattern.FactoryMethod.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 *
 * @author xiaoxinga
 * @date 2020/06/05 11:46
 * @since
 */
public class Builder {
    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
    }
}
