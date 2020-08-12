package com.xx.structureAndAlgorithm.linkedList;

/**
 * 删除链表倒数第n个节点
 *
 * @author xiaoxinga
 * @date 2020/07/07 14:14
 * @since
 */
public class Linked4 {
    public LinkNode deleteNode(LinkNode head, int n) {
        LinkNode dummy = new LinkNode<>(0);
        dummy.next = head;
        LinkNode first = dummy;
        LinkNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
