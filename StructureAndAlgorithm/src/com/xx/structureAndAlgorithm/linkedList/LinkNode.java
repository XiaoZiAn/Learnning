package com.xx.structureAndAlgorithm.linkedList;

/**
 * @author xiaoxinga
 * @date 2020/07/06 17:20
 * @since
 */
public class LinkNode<T> {
    T value;
    LinkNode<T> next;

    public LinkNode(T value, LinkNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public LinkNode(T value) {
        this.value = value;
        this.next = null;
    }
}
