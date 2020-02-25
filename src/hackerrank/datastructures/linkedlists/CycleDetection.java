/*
* A linked list is said to contain a cycle if any node is visited more than once while traversing the list.

Complete the function provided for you in your editor.
It has one parameter:
a pointer to a Node object named head that points to the head of a linked list.
Your function must return a boolean denoting whether or not there is a cycle in the list.
If there is a cycle, return true; otherwise, return false.

Note: If the list is empty, head will be null.

Constraints

0 <= list_size <= 1000
* */
package hackerrank.datastructures.linkedlists;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CycleDetection {

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

    /* Tortoise and the Hare
     The hare pointer moves 2 times the speed of
     the tortoise pointer.
     The pointers will meet if there is a cycle.
     *  */
    public boolean hasCycle(SinglyLinkedListNode head) {
        if(head == null) return false;

        // Hare pointer
        SinglyLinkedListNode h = head;
        // Tortoise pointer
        SinglyLinkedListNode t = head;

        while(h != null && h.next != null){
            h = h.next.next;
            t = t.next;
            if(h == t){
                return true;
            }
        }
        return false;
    }

    /* Store visited nodes
    * If the node is already visited there is a cycle
    * */
    public boolean hasCycle2(SinglyLinkedListNode head) {
        Set<SinglyLinkedListNode> visited = new HashSet<>();

        if(head == null) return false;
        while (head != null){
            if(!visited.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    @Test
    public void test1HasCycle(){
        //GIVEN
        SinglyLinkedList l = new SinglyLinkedList();
        l.insertNode(1);
        boolean expected = false;
        //WHEN
        boolean result = hasCycle2(l.head);
        //THEN
        assertEquals(expected, result);
    }

    @Test
    public void test1HasCycle2(){
        //GIVEN
        SinglyLinkedList l = new SinglyLinkedList();
        l.insertNode(1);
        boolean expected = false;
        //WHEN
        boolean result = hasCycle2(l.head);
        //THEN
        assertEquals(expected, result);
    }

}
