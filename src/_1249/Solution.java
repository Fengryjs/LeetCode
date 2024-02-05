package _1249;

/**
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * 请返回任意一个合法字符串。
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 * 示例 1：
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * 示例 2：
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * 示例 3：
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 * 提示：
 * 1 <= s.length <= 105
 * s[i] 可能是 '('、')' 或英文小写字母
 */
class Solution {
    public String minRemoveToMakeValid(String s) {
        int l_index = s.indexOf('(');
        StringBuilder stringBuilder = new StringBuilder(s);
        int r_index = stringBuilder.reverse().indexOf(")");
        if (l_index == -1 && r_index == -1)
            return s;
        else if (l_index == -1 || r_index == -1)
            return s.replaceAll("[()]", "");
        r_index = s.length() - r_index - 1;
        if (l_index == r_index - 1)
            return minRemoveToMakeValid(s.substring(0, l_index)) + minRemoveToMakeValid(s.substring(r_index + 1));
        else if (l_index < r_index){
            return minRemoveToMakeValid(s.substring(0, l_index)) + "(" + minRemoveToMakeValid(s.substring(l_index + 1, r_index)) + ")" +  minRemoveToMakeValid(s.substring(r_index + 1));
        } else {
            return minRemoveToMakeValid(s.substring(0, r_index) + s.substring(r_index + 1, l_index)  + s.substring(l_index + 1));
        }
    }
}