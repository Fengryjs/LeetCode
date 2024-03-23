package SimpleDataStruct;

import _0160.Solution;

public class ListNode {
    public ListNode next;
    public int val;
    public ListNode(int x) {
        val = x;
        next = null;
    }
    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
