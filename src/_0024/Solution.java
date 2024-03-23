package _0024;

import SimpleDataStruct.ListNode;

public class Solution {
    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * 示例 1：
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     * 输入：head = [1]
     * 输出：[1]
     * 提示：
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= Node.val <= 100
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode pointer = head;
        ListNode node = new ListNode(0, head);
        ListNode first = node;
        while (pointer != null && pointer.next != null) {
            ListNode next = pointer.next;
            node.next = next;
            pointer.next = next.next;
            next.next = pointer;
            node = pointer;
            pointer = pointer.next;
        }
        return first.next;
    }
}
