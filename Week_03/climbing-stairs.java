class Solution {
    // public int climbStairs(int n) {
    //     //1.递归 ,超出时间限制
    //     //终止条件
    //     if (n == 1) return 1;
    //     if (n == 2) return 2;

    //     //递归过程
    //     return climbStairs(n - 1) + climbStairs(n - 2);
    // }

    // public int climbStairs(int n) {
    //     //2.递归，带内存
    //     Map<Integer,Integer> memo = new HashMap<>();
    //     memo.put(1,1);
    //     memo.put(2,2);
    //     return helper(memo,n);
    // }

    // private int helper(Map<Integer,Integer> memo,int n) {
    //     int ans = 0 ;
    //     if (!memo.containsKey(n)) {
    //         ans = helper(memo,n - 1) + helper(memo,n - 2);
    //         memo.put(n,ans);
    //     } else {
    //         ans = memo.get(n);
    //     }
    //     return ans;
    // }

    public int climbStairs(int n) {
        //3.dp
        int first = 1;
        int second = 0;
        for (int i = 1 ; i <= n ; i++) {
            int third = first + second;
            second = first;
            first = third;
        }
        return first;
    }
}
