package _1221;

/**
 * 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的子字符串，并满足：
 * 每个子字符串都是平衡字符串。
 * 返回可以通过分割得到的平衡字符串的 最大数量
 * 示例 1：
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * 示例 2：
 * 输入：s = "RLRRRLLRLL"
 * 输出：2
 * 解释：s 可以分割为 "RL"、"RRRLLRLL"，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * 注意，s 无法分割为 "RL"、"RR"、"RL"、"LR"、"LL" 因为第 2 个和第 5 个子字符串不是平衡字符串。
 * 示例 3：
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR" 。
 * 提示：
 * 2 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * s 是一个 平衡 字符串
 *
 * 执行用时分布
 * 0
 * ms
 * 击败
 * 100.00%
 * 使用 Java 的用户
 * 消耗内存分布
 * 40.15
 * MB
 * 击败
 * 5.15%
 * 使用 Java 的用户
 */
class Solution {
    public int balancedStringSplit(String s) {
        int index = 1;
        int l_num = 0;
        int r_num = 0;
        if (s.charAt(0) == 'L')
            l_num += 1;
        else
            r_num += 1;
        while (l_num != r_num) {
            if (s.charAt(index) == 'L')
                l_num += 1;
            else
                r_num += 1;
            index += 1;
        }
        if (index == s.length())
            return 1;
        return balancedStringSplit(s.substring(0, index)) + balancedStringSplit(s.substring(index));
    }
}