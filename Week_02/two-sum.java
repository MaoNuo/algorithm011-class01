import java.util.*;

class Solution {
    //使用哈希表进行查找
    /*
        在向后方遍历的时候，我们可以得出 target - nums[i]的值
        如果这个值前面不存在，则将当前值放入map中
        如果存在，则取出查找值的目录
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[2];
    }

}