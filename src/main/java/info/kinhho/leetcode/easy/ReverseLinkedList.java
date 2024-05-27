package info.kinhho.leetcode.easy;

import info.kinhho.leetcode.objectvalues.ListNode;

import java.util.Arrays;
import java.util.Objects;

/**
 * Problem:
 * You are given non-empty linked lists.
 * Reverse the linked list.
 *
 * Example 1:
 * Input: l1 = [1,2,3]
 * Output: [3,2,1]
 *
 * Example 2:
 * Input: l1 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [2,9,3,8,5,7,6]
 * Output: [6,7,5,8,3,9,2]
 */
public class ReverseLinkedList {

    public static ListNode bestSolution(ListNode head) {

        // One time pass LinkedList -> O(n), S(1)
        ListNode current = head;
        ListNode prev = null;
        while ( !Objects.isNull( current ) ) {
            ListNode forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
        }
        return prev;
    }

    public static ListNode mySolution(ListNode head) {

        // **
        // One time pass LinkedList -> O(n), S(1)
        ListNode current = head;
        ListNode prev = null;
        while ( !Objects.isNull( current ) ) {
            ListNode forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
        }
        return prev;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode duplicate = null;
        try {
            duplicate = head.clone();
        }
        catch (CloneNotSupportedException ex) {

        }
         var bestSolution = bestSolution(head);
         var mySolution = mySolution(duplicate);

        printListNode( bestSolution );
        printListNode( mySolution );
    }
    private static void printListNode(ListNode node) {
        ListNode temp = node;
        if ( Objects.isNull( temp ) ) {
            System.out.println("[]");
            return;
        }

        System.out.print("[");
        while (! Objects.isNull( temp ) ) {
            System.out.print( temp.val );
            if ( !Objects.isNull( temp.next ) ) {
                System.out.print(", ");
            }
            temp = temp.next;
        }
        System.out.println("]");
    }
}
