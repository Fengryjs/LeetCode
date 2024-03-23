package _0019;

import SimpleDataStruct.ListNode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = head;
        int index = 0;
        HashMap<Integer, ListNode> map = new HashMap<>();
        while (tail.next != null) {
            map.put(index, tail);
            tail = tail.next;
        }

        ListNode target = map.get(index - n);
        target.next = map.getOrDefault(index - n + 2, null);
        return head;
    }
}
