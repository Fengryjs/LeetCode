package _0160;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.List;
import SimpleDataStruct.ListNode;
public class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, ListNode> nodeHashMap = new HashMap<>();
        ListNode firstConcat = null;
        ListNode current = headA;
        while (current != null) {
            nodeHashMap.put(current, current);
            current = current.next;
        }
        current = headB;
        while (current != null) {
            if (nodeHashMap.containsKey(current)) {
                return current;
            }
            current = current.next;
        }
        return null;
        /**
         * //非常牛逼的思路，假设A是一条路径，B也是一条路径，那么如果我们同时移动AB，使他们移动的距离相等，那么一定会在某一刻使得两者相等
         * if (headA == null || headB == null) {
         *             return null;
         *         }
         *         ListNode pA = headA, pB = headB;
         *         while (pA != pB) {
         *             pA = pA == null ? headB : pA.next;
         *             pB = pB == null ? headA : pB.next;
         *         }
         *         return pA;
         *
         * 作者：力扣官方题解
         * 链接：https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/811625/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
    }
}
