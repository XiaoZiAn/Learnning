package com.xx.designpattern.BehaviorPattern.Iterator;

/**
 * @author xiaoxinga
 * @date 2020/06/08 14:17
 * @since
 */
public class MyCollection implements Collection {
    public String string[] = {"A","B","C","D","E"};
    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int i) {
        return string[i];
    }

    @Override
    public int size() {
        return string.length;
    }
}
