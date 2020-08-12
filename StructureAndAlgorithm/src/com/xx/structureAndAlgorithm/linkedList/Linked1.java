package com.xx.structureAndAlgorithm.linkedList;

/**
 * 单链表反转
 *
 * @author xiaoxinga
 * @date 2020/07/06 17:20
 * @since
 */
public class Linked1 {
    public static void main(String[] args) {
        LinkNode<Integer> head = new LinkNode<Integer>(1, new LinkNode<>(2, new LinkNode<>(3, new LinkNode<>(4,
                new LinkNode<>(5, new LinkNode<>(6, null))))));
        Linked1 linked1 = new Linked1();
        LinkNode<Integer> newHead = linked1.reversal(head);
    }

    public LinkNode<Integer> reversal(LinkNode<Integer> head) {
        if (head == null || head.next == null)
            return head;
        LinkNode<Integer> a = null;
        LinkNode<Integer> b = head;
        LinkNode<Integer> c = head.next;
        while (b != null) {
            b.next = a;
            a = b;
            b = c;
            if (c != null)
                c = c.next;
        }
        return a;
    }
}
