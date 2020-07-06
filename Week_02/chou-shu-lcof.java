import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
//    public int nthUglyNumber(int n) {
//        //动态规划
//        /*
//            原理 ： 丑数只有2，3，5三个因数，所以比起遍历排除
//                   在原基础上相乘的效率肯定是最高的
//                   但是只是单纯的迭代着乘，会出现顺序紊乱的情况
//                   那么使用动态规划，维护三个数，
//                   分别以数组的起点为起点，表示应该乘的因子
//         */
//        int a = 0 , b = 0 , c = 0;
//        int[] dp = new int[n];
//        dp[0] = 1;
//        for (int i = 1; i < n; i++) {
//            int n2 = dp[a] * 2, n3 = dp[b] * 3 , n5 = dp[c] * 5;
//            dp[i] = Math.min(Math.min(n2,n3),n5);
//            if (dp[i] == n2) { a++; }
//            if (dp[i] == n3) { b++; }
//            if (dp[i] == n5) { c++; }
//        }
//        return dp[n - 1];
//    }

    public int nthUglyNumber(int n) {
        //使用堆，在Java中可以使用优先队列
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        long[] primes = new long[]{2,3,5};
        pq.add((long)1);
        long num = 1;
        for (int i = 0; i < n; i++) {
            num = pq.poll();
            for (int j = 0; j < primes.length; j++) {
                long uglyNum = num * primes[j];
                if (!set.contains(uglyNum)) {
                    pq.add(uglyNum);
                    set.add(uglyNum);
                }
            }
        }
        return (int)num;
    }
}