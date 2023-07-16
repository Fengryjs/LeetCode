package _1901;

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        boolean finish = false;
        int x = 0;
        int y = 0;
        // System.out.println(mat.length);
        // System.out.println(mat[0].length);
        while (!finish) {
            for (int i = 0; i < mat.length; i++)
                if (mat[i][y] > mat[x][y])
                    x = i;
            if (y == 0) {
                if (mat[x][y] > mat[x][y + 1])
                    break;
            } else if (y == mat[0].length - 1) {
                if (mat[x][y] > mat[x][y - 1])
                    break;
            } else if ((mat[x][y] > mat[x][y + 1]) && mat[x][y] > mat[x][y - 1]) {
                break;
            }

            for (int i = 0; i < mat[0].length; i++)
                if (mat[x][i] > mat[x][y])
                    y = i;

            if (x == 0) {
                if (mat[x][y] > mat[x + 1][y])
                    break;
            } else if (x == mat.length - 1) {
                if (mat[x][y] > mat[x - 1][y])
                    break;
            } else if (mat[x][y] > mat[x + 1][y] && mat[x][y] > mat[x - 1][y])
                break;
        }

        return new int[]{x, y};
    }
}