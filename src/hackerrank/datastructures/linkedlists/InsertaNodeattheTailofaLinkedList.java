/*
* You are given the pointer to the head node of a linked list and an integer to add to the list.
* Create a new node with the given integer. Insert this node at the tail of the linked list and return
* the head node of the linked list formed after inserting this new node. The given head pointer may be null,
* meaning that the initial list is empty.
* */
package hackerrank.datastructures.linkedlists;


import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */
public class InsertaNodeattheTailofaLinkedList {

    public class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }
    }

    public SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        // If linked list is empty initialize whit new Node and return it
        if(head == null){
            return newNode;
        }
        // head start as a tail
        SinglyLinkedListNode tail = head;

        // while next node in the tail is not null go to the next node
        while(tail.next != null){
            tail = tail.next;
        }
        // once the next element is null, means is the end of the linked list and we can add the new node
        tail.next = newNode;
        // return the head of the linked list
        return head;
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
        list.head  = insertNodeAtTail(list.head, 141);
        list.head  = insertNodeAtTail(list.head, 302);
        list.head  = insertNodeAtTail(list.head, 164);
        list.head  = insertNodeAtTail(list.head, 530);
        list.head  = insertNodeAtTail(list.head, 474);
        //THEN
        System.out.println();
        printSinglyLinkedList(list.head);
    }


    @Test
    public void test2Solution(){
        //GIVEN
        SinglyLinkedList list = new SinglyLinkedList();
        //WHEN
        list.head  = insertNodeAtTail(list.head, 236);
        list.head  = insertNodeAtTail(list.head, 326);
        list.head  = insertNodeAtTail(list.head, 937);
        //THEN
        System.out.println();
        printSinglyLinkedList(list.head);
    }

}
