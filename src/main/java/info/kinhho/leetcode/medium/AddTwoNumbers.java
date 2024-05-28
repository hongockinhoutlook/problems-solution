package info.kinhho.leetcode.medium;

import info.kinhho.leetcode.objectvalues.ListNode;
import static info.kinhho.leetcode.objectvalues.ListNode.printListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

    // Runtime 2ms, Memory: 44.45Mb
    public static ListNode bestSolution(ListNode l1, ListNode l2) {

        ListNode dh = new ListNode(0);
        ListNode t = dh;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int d1, d2;
            if (l1 != null) {
                d1 = l1.val;
                l1 = l1.next;
            } else
                d1 = 0;
            if (l2 != null) {
                d2 = l2.val;
                l2 = l2.next;
            } else
                d2 = 0;

            int sum = d1 + d2 + carry;
            int d = sum % 10;
            carry = sum / 10;
            ListNode newnode = new ListNode(d);
            t.next = newnode;
            t = t.next;
        }
        ListNode res = dh.next;
        dh.next = null;
        return res;
    }

    // Runtime: 1ms, Memory: 44.43Mb
    public static ListNode mySolution(ListNode l1, ListNode l2) {

        // Time Consuming O(n) + 1, S(n)
        ListNode head = null, tail = null;
        int remainder = 0, balance = 0;
        while ( l1 != null || l2 != null ) {

            // get value from l1
            int l1val = l1 != null ? l1.val : 0;
            // get value from l2
            int l2val = l2 != null ? l2.val : 0;

            int total = l1val + l2val + remainder;
            remainder = (int) total / 10;
            balance = total % 10;

            if ( head == null ) {
                head = new ListNode( balance );
                tail = head;
            }
            else {
                ListNode cloneTail = tail;
                ListNode newNode = new ListNode(balance);
                cloneTail.next = newNode;
                tail = newNode;
            }

            if ( l1 != null ) {
                l1 = l1.next;
            }
            if ( l2 != null  ) {
                l2 = l2.next;
            }
        }
        if ( remainder != 0 ) {
            ListNode cloneTail = tail;
            ListNode newNode = new ListNode(1);
            cloneTail.next = newNode;
            tail = newNode;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode lnode1 = new ListNode(9);
        ListNode lnode2 = new ListNode(9);
        ListNode lnode3 = new ListNode(9);
        ListNode lnode4 = new ListNode(9);
        lnode1.next = lnode2;
        lnode2.next = lnode3;
        lnode3.next = lnode4;


//        System.out.println( Arrays.toString( bestSolution(nums,58 ) ) );
        printListNode( mySolution(node1, lnode1 ) );
    }
}

