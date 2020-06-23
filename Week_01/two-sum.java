import java.util.HashMap;
import java.util.Map;

/*
    1.两层遍历
    2.一边哈希
 */
class Solution {
    //1.两层遍历
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }

    //2.一遍哈希
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            }else {
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}