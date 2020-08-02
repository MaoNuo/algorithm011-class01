class Solution {
    public int maximalSquare(char[][] matrix) {
        //对于每一个为1的点而言
        //他能组成的最大正方形为左上，左，上三个方位的点能组成的正方形的最小值 + 1
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    int top = i > 0 ? dp[i - 1][j] : 0;
                    int left = j > 0 ? dp[i][j - 1] : 0;
                    int lefttop = i > 0 && j > 0 ? dp[i - 1][j - 1] : 0;
                    dp[i][j] = Math.min(Math.min(top, left), lefttop) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
