class Solution {
    public boolean isPowerOfTwo(int n) {
    //n & (n - 1)
    //二进制减一操作，会将最后一位的1变为0，然后将后面所有的位全变成1
    //之后再与原数做并操作，就相当于将原数的最后一个1替换为0
        return (n != 0) && (n & (n - 1)) == 0;
    }
}
