package info.kinhho.leetcode.objectvalues;

import java.util.Objects;

public class ListNode implements Cloneable {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public ListNode clone() throws CloneNotSupportedException {
        return (ListNode) super.clone();
    }

    public static void printListNode(ListNode node) {
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
