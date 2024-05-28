package info.kinhho.leetcode.easy;

import info.kinhho.leetcode.objectvalues.ListNode;

import static info.kinhho.leetcode.objectvalues.ListNode.printListNode;

public class SimpleLinkedList {

    public static void main(String[] args) {

        ListNode head = null, tail = null;

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < nums.length; i++) {
            if ( head == null ) {
                head = new ListNode( nums[i]);
                tail = head;
            }
            else {
                ListNode tempTail = tail;
                ListNode node = new ListNode( nums[i]);
                tempTail.next = node;
                tail = node;
            }
        }

        printListNode( head );
    }
}
