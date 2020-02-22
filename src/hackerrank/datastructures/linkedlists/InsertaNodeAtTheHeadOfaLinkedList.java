/*
You’re given the pointer to the head node of a linked list and an integer to add to the list.
Create a new node with the given integer, insert this node at the head of the linked list and return the new head node.
The head pointer given may be null meaning that the initial list is empty.
* */
package hackerrank.datastructures.linkedlists;

import org.junit.Test;

public class InsertaNodeAtTheHeadOfaLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }


    }
    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    public SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if(llist != null){
            newNode.next = llist;
        }
        return newNode;
    }

    public void printSinglyLinkedList(SinglyLinkedListNode node){
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    @Test
    public void test1Solution(){
        //GIVEN
        SinglyLinkedList list = new SinglyLinkedList();
        //WHEN
        list.head  = insertNodeAtHead(list.head, 383);
        list.head  = insertNodeAtHead(list.head, 484);
        list.head  = insertNodeAtHead(list.head, 392);
        list.head  = insertNodeAtHead(list.head, 975);
        list.head  = insertNodeAtHead(list.head, 321);
        //THEN
        System.out.println();
        printSinglyLinkedList(list.head);
    }

    @Test
    public void test2Solution(){
        //GIVEN
        SinglyLinkedList list = new SinglyLinkedList();
        //WHEN
        list.head  = insertNodeAtHead(list.head, 321);
        list.head  = insertNodeAtHead(list.head, 641);
        list.head  = insertNodeAtHead(list.head, 653);
        list.head  = insertNodeAtHead(list.head, 524);
        list.head  = insertNodeAtHead(list.head, 952);
        list.head  = insertNodeAtHead(list.head, 337);
        list.head  = insertNodeAtHead(list.head, 955);
        list.head  = insertNodeAtHead(list.head, 891);
        list.head  = insertNodeAtHead(list.head, 590);
        list.head  = insertNodeAtHead(list.head, 133);

        //THEN
        System.out.println();
        printSinglyLinkedList(list.head);
    }
}
