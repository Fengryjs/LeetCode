package _0021;

import SimpleDataStruct.ListNode;

import java.util.List;

public class Solution {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例 1：
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     * 提示：
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode point1 = list1;
        ListNode point2 = list2;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode node = new ListNode(0);
        ListNode result = node;
        while (point1 != null && point2 != null) {
            if (point1.val < point2.val) {
                node.val = point1.val;
                point1 = point1.next;
            } else {
                node.val = point2.val;
                point2 = point2.next;
            }
            node.next = new ListNode(0);
            node = node.next;
        }
        if (point1 == null) {
            node.val = point2.val;
            node.next = point2.next;
        } else {
            node.val = point1.val;
            node.next = point1.next;
        }
        return result;
    }
}
