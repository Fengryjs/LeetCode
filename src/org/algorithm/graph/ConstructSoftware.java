package org.algorithm.graph;

import java.util.*;

/**
 * 117. 软件构建
 * 题目描述
 *
 * 某个大型软件项目的构建系统拥有 N 个文件，文件编号从 0 到 N - 1，在这些文件中，某些文件依赖于其他文件的内容，这意味着如果文件 A 依赖于文件 B，则必须在处理文件 A 之前处理文件 B （0 <= A, B <= N - 1）。请编写一个算法，用于确定文件处理的顺序。
 * 输入描述
 *
 * 第一行输入两个正整数 N, M。表示 N 个文件之间拥有 M 条依赖关系。
 * 后续 M 行，每行两个正整数 S 和 T，表示 T 文件依赖于 S 文件。
 * 输出描述
 *
 * 输出共一行，如果能处理成功，则输出文件顺序，用空格隔开。
 * 如果不能成功处理（相互依赖），则输出 -1。
 * 输入示例
 *
 * 5 4
 * 0 1
 * 0 2
 * 1 3
 * 2 4
 * 输出示例
 *
 * 0 1 2 3 4
 * 提示信息
 *
 * 文件依赖关系如下：
 *
 *
 *
 * 所以，文件处理的顺序除了示例中的顺序，还存在
 * 0 2 4 1 3
 * 0 2 1 3 4
 * 等等合法的顺序。
 * 数据范围：
 * 0 <= N <= 10 ^ 5
 * 1 <= M <= 10 ^ 9
 *
 * 每行末尾无空格。
 */
public class ConstructSoftware {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fileCount = scanner.nextInt();
        int dependencyCount = scanner.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < dependencyCount; i++) {
            int in = scanner.nextInt();
            int out = scanner.nextInt();
            List<Integer> depend = map.getOrDefault(out, new ArrayList<>());
            depend.add(in);
            map.put(out, depend);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < fileCount; i++) {
            if (!map.containsKey(i)) {
                res.add(i);
                int finalI = i;
                map.forEach((k, v) -> v.remove((Object) finalI));
            }
        }
        while (true) {
            List<Integer> deleted = new ArrayList<>();
            for (Integer i: map.keySet()) {
                if (map.get(i).isEmpty()) {
                    res.add(i);
                    deleted.add(i);
                }
            }
            for (Integer i : deleted) {
                map.forEach((k, v) -> v.remove(i));
                map.remove(i);
            }

            boolean hasMore = false;
            for (Integer i : map.keySet()) {
                if (map.get(i).isEmpty()) {
                    hasMore = true;
                }
            }
            if (!hasMore) {
                break;
            }
        }
        if (res.size() == fileCount) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer i: res) {
                stringBuilder.append(i);
                stringBuilder.append(" ");
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            System.out.println(stringBuilder.toString());
        } else {
            System.out.println(-1);
        }
    }
}
