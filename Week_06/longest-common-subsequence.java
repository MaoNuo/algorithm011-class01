class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //建立二维dp数组
        //子问题：每个字符串减去n个字符之后的最长公共长度
        //对于每个字符串而言，如果一方为空，则得到0
        //双方均不为空的字符串，对比双方最后一个字符
        //如果相等，则应对子问题：两个字符串各减去最后一个字符后的长度+1
        //如果不想等，则应对某方减去一个字符之后与另一个字符比较的较大值
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i <= 0 || j <= 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    if (i <= 0 && j <= 0) {
                        dp[i][j] = 0;
                    } else if (i <= 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (j <= 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
