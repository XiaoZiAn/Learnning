package com.xx.designpattern.BehaviorPattern.Iterator;

/**
 * @author xiaoxinga
 * @date 2020/06/08 14:17
 * @since
 */
public interface Iterator {
    //前移
    public Object previous();

    //后移
    public Object next();

    public boolean hasNext();

    //取得第一个元素
    public Object first();
}
