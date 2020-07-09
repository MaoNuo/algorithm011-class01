class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(result, list, nums, 0, used);

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int level, boolean[] used) {
        //1.终止条件 ： 所有数字都用到
        if (level == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        //对于每一层来说，有一个属于该层的set，用于去重
        Set<Integer> set = new HashSet<>();

        //2.本层操作 ： 挑选一个不重复的未使用的数，添加到list中
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (!set.contains(nums[i])) {
                    list.add(nums[i]);
                    used[i] = true;
                    set.add(nums[i]);
                    //进入下一层
                    helper(result, list, nums, level + 1, used);
                    //递归完回到这一层，取消所有操作
                    used[i] = false;
                    list.remove(level);
                }
            }
        }
    }
}
