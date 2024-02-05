package _691;

/**
 * 我们有 n 种不同的贴纸。每个贴纸上都有一个小写的英文单词。
 *
 * 您想要拼写出给定的字符串 target ，方法是从收集的贴纸中切割单个字母并重新排列它们。如果你愿意，你可以多次使用每个贴纸，每个贴纸的数量是无限的。
 *
 * 返回你需要拼出 target 的最小贴纸数量。如果任务不可能，则返回 -1 。
 *
 * 注意：在所有的测试用例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选择的，并且 target 被选择为两个随机单词的连接。
 *
 *
 *
 * 示例 1：
 *
 * 输入： stickers = ["with","example","science"], target = "thehat"
 * 输出：3
 * 解释：
 * 我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
 * 把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
 * 此外，这是形成目标字符串所需的最小贴纸数量。
 * 示例 2:
 *
 * 输入：stickers = ["notice","possible"], target = "basicbasic"
 * 输出：-1
 * 解释：我们不能通过剪切给定贴纸的字母来形成目标“basicbasic”。
 *
 *
 * 提示:
 *
 * n == stickers.length
 * 1 <= n <= 50
 * 1 <= stickers[i].length <= 10
 * 1 <= target.length <= 15
 * stickers[i] 和 target 由小写英文单词组成
 *
 * 一个二维完全背包问题
 */
class Solution {

    int[] targetAlphaTime = new int[26];
    public int minStickers(String[] stickers, String target) {
        mapAlpha(target, targetAlphaTime);
        // 每个sticker可以拆分出来的字母次数
        int[][] stickersAlphaTime = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++)
            mapAlpha(stickers[i], stickersAlphaTime[i]);
        // 每个字母进行背包算法的结果
        int[][] minBag = new int[26][stickers.length];
        for (int i = 0; i < 26; i++)
            minBag[i] = bag(getColumn(stickersAlphaTime, i), targetAlphaTime[i]);

        return 0;
    }

    public void mapAlpha(String target, int[] alphaTime) {
        for (int i = 0; i < target.length(); i++)
            alphaTime[target.charAt(i) - 'a'] += 1;
    }

    public int[] bag(int[] alphaTime, int need) {
        int[] time = new int[alphaTime.length];

        return time;
    }

    public int[] getColumn(int[][] array, int index) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++)
            result[i] = array[index][i];
        return result;
    }
}
