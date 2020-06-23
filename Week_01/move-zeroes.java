/*
    1.原地交换
    2.滚雪球
 */

class Solution {
//    public void moveZeroes(int[] nums) {
//        // j 表示数组中非0的数的index
//        int j = 0;
//        //遍历全数组
//        for (int i = 0 ; i < nums.length ; i++) {
//            //当该数为非0的时候，将其移动到j的位置上
//            if (nums[i] != 0) {
//                nums[j] = nums[i];
//                //如果 i ！= j （该数不在原位置） ， 则将原index的数改为0
//                if (i != j) {
//                    nums[i] = 0;
//                }
//                j++ ;
//            }
//        }
//    }

    public void moveZeroes(int[] nums) {
        //当碰到0的时候，将与后面的第一个非0的数交换
        //则所有的0会在一起越来越多，如同一个雪球

        //记录雪球的大小
        int snowballSize = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果该数为0，则雪球变大
            if (nums[i] == 0) {
                snowballSize++;
            }
            //不为0，则与第一个0交换位置
            //仅当前面有0时交换
            else if (snowballSize > 0){
                nums[i - snowballSize] = nums[i];
                nums[i] = 0;
            }
        }
    }

}