import java.util.Arrays;

/*
Method 1:将数组复制一份至尾部，复制中间从k位开始的一份长度的数组 O（n） ...... 3n
Method 2:循环k次，每次移动一步 O（n^2）
Method 3:反转3次
Method 4:环形交换
 */
class Solution {
//    Method 1: 0ms , 40.3Mb
//    public void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        int[] temp = new int[nums.length * 2];
//        System.arraycopy(nums,0,temp,0,nums.length);
//        System.arraycopy(nums,0,temp,nums.length,nums.length);
//        System.arraycopy(temp,nums.length - k, nums, 0, nums.length);
//    }

//    Method 2: 124ms, 40.3Mb
//    public void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        for (int i = 0; i < k; i++) {
//            int index = nums.length - k + i;
//            int temp = nums[index];
//            for (int j = 0; j < nums.length - k; j++) {
//                nums[index - j] = nums[index - j - 1];
//            }
//            nums[i] = temp;
//        }
//    }

//    Method 3: 0ms, 40,4Mb
//    public void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        reverse(nums,0,nums.length);
//        reverse(nums,0,k);
//        reverse(nums,k,nums.length - k);
//    }
//
//    private void reverse(int[] nums, int start, int length) {
//        int end = start + length - 1;
//        while (start < end) {
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++; end--;
//        }
//    }

//    Method 4: 0ms,40.2Mb
    public void rotate(int[] nums,int k) {
        k = k % nums.length;
        //一共循环k次，每次循环会将倒数第k个数交换到第k个位置上
        int count = 0;
        int start = 0;
        while (count < nums.length) {
            int index = start;
            int temp = nums[index];
            do {
                int newIndex = (index + k) % nums.length;
                int newTemp = nums[newIndex];
                nums[newIndex] = temp;
                temp = newTemp;
                index = newIndex;
                count++;
            }while (index != start);
            start++;
        }
    }

}