class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            //在图表中，用极大值减去极小值就是总利益
            //在一段单调递增的区间中
            //每两个点的差的和等于极大值减去极小值的值
            //所以只用判断当前位置是否处于递增状态即可
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
