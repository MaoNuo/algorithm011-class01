class Solution {
    // public double myPow(double x, int n) {
    //     // 1.暴力法
    //     if (n == 0) { return 1.0; }
    //     if (n < 0) { return myPow(1 / x, -n); }
    //     double result = 1.0;
    //     for (int i = 0; i < n; i++) {
    //         result *= x;
    //     }
    //     return result;
    // }

    // private double quickMul(double x, long n) {
    //     //2.快速幂 递归
    //     if (n == 0) { return 1.0; }

    //     double subResult = quickMul(x, n / 2);
    //     subResult *= subResult;
    //     return (n & 1) == 1 ?  subResult * x : subResult;
    // }

    // public double myPow(double x, int n) {
    //     long b = n;
    //     return b > 0 ? quickMul(x, b) : quickMul(1 / x, -b);
    // }

    public double myPow(double x, int n) {
        //2.快速幂，迭代
        if (n == 0) { return 1.0; }
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        double result = 1.0;
        while (b > 0) {
            if ((b & 1) == 1) {
                result *= x;
            }
            x *= x;
            b >>>= 1;
        }

        return result;

    }
}
