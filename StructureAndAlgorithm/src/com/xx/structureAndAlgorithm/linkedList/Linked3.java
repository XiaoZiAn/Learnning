package com.xx.structureAndAlgorithm.linkedList;

/**
 * 两个有序列表合并
 * @author xiaoxinga
 * @date 2020/07/07 10:59
 * @since
 */
public class Linked3 {
    public LinkNode<Integer> mergeTwoLists(LinkNode<Integer> l1, LinkNode<Integer> l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.value < l2.value) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
