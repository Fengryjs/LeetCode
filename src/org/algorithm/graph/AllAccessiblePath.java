package org.algorithm.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 98. 所有可达路径
 * 题目描述
 *
 * 给定一个有 n 个节点的有向无环图，节点编号从 1 到 n。请编写一个函数，找出并返回所有从节点 1 到节点 n 的路径。每条路径应以节点编号的列表形式表示。
 * 输入描述
 *
 * 第一行包含两个整数 N，M，表示图中拥有 N 个节点，M 条边
 * 后续 M 行，每行包含两个整数 s 和 t，表示图中的 s 节点与 t 节点中有一条路径
 * 输出描述
 *
 * 输出所有的可达路径，路径中所有节点之间空格隔开，每条路径独占一行，存在多条路径，路径输出的顺序可任意。如果不存在任何一条路径，则输出 -1。
 * 注意输出的序列中，最后一个节点后面没有空格！ 例如正确的答案是 `1 3 5`,而不是 `1 3 5 `， 5后面没有空格！
 * 输入示例
 *
 * 5 5
 * 1 3
 * 3 5
 * 1 2
 * 2 4
 * 4 5
 * 输出示例
 *
 * 1 3 5
 * 1 2 4 5
 * 提示信息
 *
 *
 *
 * 用例解释：
 * 有五个节点，其中的从 1 到达 5 的路径有两个，分别是 1 -> 3 -> 5 和 1 -> 2 -> 4 -> 5。
 * 因为拥有多条路径，所以输出结果为：
 * 1 3 5
 * 1 2 4 5
 * 或
 * 1 2 4 5
 * 1 3 5
 * 都算正确。
 *
 * 数据范围：
 * 图中不存在自环
 * 图中不存在平行边
 * 1 <= N <= 100
 * 1 <= M <= 500
 */
public class AllAccessiblePath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int node = scanner.nextInt();
        int side = scanner.nextInt();
        List<List<Integer>> res = new ArrayList<>();
        int[][] vector = new int[node][node];
        for (int i = 0; i < side; i++) {
            int begin = scanner.nextInt();
            int end = scanner.nextInt();
            vector[begin - 1][end - 1] = 1;
        }
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(res, vector, path, 0);
        if (res.size() == 0) {
            System.out.println(-1);
        } else {
            for (List<Integer> p: res) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Integer i: p) {
                    stringBuilder.append(i + 1);
                    stringBuilder.append(" ");
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                System.out.println(stringBuilder.toString());
            }
        }
    }

    public static void dfs(List<List<Integer>> res, int[][] vector, List<Integer> currentPath, int i) {
        if (i == vector.length - 1) {
            res.add(new ArrayList<>(currentPath));
            return;
        }
        for (int j = 0; j < vector.length; j++) {
            int side = vector[i][j];
            if (side == 1) {
                currentPath.add(j);
                dfs(res, vector, currentPath, j);
                currentPath.remove((Object) j);
            }
        }
    }
}
