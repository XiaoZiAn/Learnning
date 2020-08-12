package com.xx.structureAndAlgorithm.linkedList;

/**
 * @author xiaoxinga
 * @date 2020/07/08 10:41
 * @since
 */
public class MyLinkedList {
    private Node head;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node node = head;
        int n = 0;
        while (node != null) {
            if (n == index)
                return node.val;
            node = node.next;
            n++;
        }
        return -1;

    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be
     * the first node of the linked list.
     */
    public void addAtHead(int val) {
        if(head==null)
            head = new Node(val);
        else {
            Node node = head;
            Node newHead = new Node(val);
            newHead.next = node;
            head = newHead;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if(head==null)
            head = new Node(val);
        Node node = head;
        while (node.next!=null)
            node = node.next;
        node.next = new Node(val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
     * list, the node will be appended to the end of linked list. If index is greater than the length, the node will
     * not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if(index<=0)
            addAtHead(val);
        else if()
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node node = new Node(-1);
        node.next = head;
        int n = -1;
        while(node!=null){
            if(n==index){
                node.next=node.next.next;
                break;
            }
            node = node.next;
            n++;
        }
    }
}
