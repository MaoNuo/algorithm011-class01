/*
双指针
1 前面的指针指向已排好的数，并且处于返回长度的最末尾位置
2 后面的指针与前指针相比，若相同则往后走
3 若不同 则将后指针的数放入前指针后面的位置 前指针后移1
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int pre = 0 , cur = 1;
        while (cur < nums.length) {
            while (cur < nums.length && nums[cur] == nums[pre]) cur++;
            if (cur < nums.length) {
                nums[++pre] = nums[cur];
            }
        }
        return pre + 1;
    }
}
