package com.xx.structureAndAlgorithm.linkedList;

/**
 * 链表中环的检测
 *
 * @author xiaoxinga
 * @date 2020/07/07 9:48
 * @since
 */
public class Linked2 {
    public static void main(String[] args) {
        LinkNode<Integer> head = new LinkNode<Integer>(1);
        LinkNode<Integer> node1 = new LinkNode<Integer>(2);
        LinkNode<Integer> node2 = new LinkNode<Integer>(3);
        LinkNode<Integer> node3 = new LinkNode<Integer>(4);
        LinkNode<Integer> node4 = new LinkNode<Integer>(5);
        LinkNode<Integer> node5 = new LinkNode<Integer>(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        Linked2 linked2 = new Linked2();
        boolean isRing = linked2.isRing(head);
    }

    public boolean isRing(LinkNode<Integer> head) {
        if (head == null || head.next == null) {
            return false;
        }
        LinkNode<Integer> slow = head;
        LinkNode<Integer> fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
