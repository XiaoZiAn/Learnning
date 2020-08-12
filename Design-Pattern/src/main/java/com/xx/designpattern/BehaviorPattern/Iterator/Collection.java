package com.xx.designpattern.BehaviorPattern.Iterator;

/**
 * @author xiaoxinga
 * @date 2020/06/08 14:16
 * @since
 */
public interface Collection {
    public Iterator iterator();

    /*取得集合元素*/
    public Object get(int i);

    /*取得集合大小*/
    public int size();
}
