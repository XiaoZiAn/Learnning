package com.xx.designpattern.BehaviorPattern.Iterator;

/**
 * @author xiaoxinga
 * @date 2020/06/08 14:20
 * @since
 */
public class Test {
    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
