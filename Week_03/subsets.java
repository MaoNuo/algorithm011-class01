class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(result, list, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        //1.终止条件
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        //2.当前处理和进入到下一层
        backtrack(result, list, nums, index + 1); //不添加当前元素进入下一层

        list.add(nums[index]);
        backtrack(result, list, nums, index + 1); //添加当前元素进入下一层

        list.remove(list.size() - 1); //还原
    }
}
