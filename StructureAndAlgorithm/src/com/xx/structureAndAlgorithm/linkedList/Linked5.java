package com.xx.structureAndAlgorithm.linkedList;

/**
 * @author xiaoxinga
 * @date 2020/07/07 14:48
 * @since
 */
public class Linked5 {
    public LinkNode middleNode(LinkNode head) {
        if (head == null || head.next == null)
            return head;
        LinkNode mid = head;
        LinkNode end = mid;
        while (end != null && end.next != null) {
            end = end.next.next;
            mid = mid.next;
        }
        return mid;
    }
}
