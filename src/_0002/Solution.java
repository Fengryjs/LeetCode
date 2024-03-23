package _0002;

import SimpleDataStruct.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersWithCarry(l1, l2, 0);
    }

    public ListNode addTwoNumbersWithCarry(ListNode l1, ListNode l2, int carry) {
        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }
        ListNode node = new ListNode(sum % 10);
        if (l1 == null && l2 == null && sum == 0)
            node.next = null;
        else
            node.next = addTwoNumbersWithCarry(l1, l2, sum / 10);
        return node;
    }
}
