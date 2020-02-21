/*
Given a pointer to the head node of a linked list, print its elements in order, one element per line.
If the head pointer is null (indicating the list is empty), don’t print anything.
* */
package hackerrank.datastructures.linkedlists;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PrinttheElementsoftheLinkedList {

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

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
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
    public void printLinkedList(SinglyLinkedListNode head) {
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    /*Add as many tests as required*/
    @Test
    public void test1Solution(){
        //GIVEN
        SinglyLinkedList llist = new SinglyLinkedList();
        llist.insertNode(16);
        llist.insertNode(13);
        //WHEN
        printLinkedList(llist.head);
        //THEN
        assertTrue(true);
    }
}
