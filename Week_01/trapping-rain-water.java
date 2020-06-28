class Solution {
//
//    //1. 暴力
//    /*
//        对于每一列的水滴来说，该列所接到的雨水为两边最大值中的较小一方
//     */
//    public int trap(int[] height) {
//        int ans = 0;
//        for (int i = 1; i < height.length - 1; i++) {
//            int max_left = 0 , max_right = 0;
//            for (int j = i; j >= 0; j--) {
//                max_left = Math.max(max_left,height[j]);
//            }
//            for (int j = i; j < height.length; j++) {
//                max_right = Math.max(max_right,height[j]);
//            }
//            ans += Math.min(max_left,max_right) - height[i];
//        }
//
//        return ans;
//    }

    //2.优化
    /*
        不用每次都左右遍历
        将其最大值一次遍历下来用一个数组存储
     */
    public int trap(int[] height) {
        int ans = 0;
        int[] max_left = new int[height.length], max_right = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i - 1],height[i]) ;
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1],height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.min(max_left[i],max_right[i]) - height[i];
        }
        return ans;
    }
}