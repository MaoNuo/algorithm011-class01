class Solution {
    public int minPathSum(int[][] grid) {
        //一维数组即可解决问题
        //对于每一个格子来说，只有可能从旁边和上面过来
        //所以只需要取这两个格子的最小值即可
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0) {
                    dp[j] = grid[i][j];
                    dp[j] += j == 0 ? 0 : dp[j - 1];
                } else {
                    dp[j] = j == 0 ? dp[j] : Math.min(dp[j - 1], dp[j]);
                    dp[j] += grid[i][j];
                }
            }
        }
        return dp[grid[0].length - 1];
    }
}
