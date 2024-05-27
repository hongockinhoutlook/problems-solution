package info.kinhho.leetcode.objectvalues;

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
}
