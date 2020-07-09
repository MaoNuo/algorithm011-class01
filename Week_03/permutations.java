class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(result,nums,list,0,used);
        return result;
    }

    private void helper(List<List<Integer>> result,int[] nums,List<Integer> list,int level,boolean[] used) {
        //终止条件：数组长度一致
        if (level == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        //当前层次处理，将未加入的数组加到list中
        for (int i = 0; i < nums.length; i++) {
            // if (list.contains(nums[i])) { continue; }
            // list.add(nums[i]);
            // //进入下一层
            // helper(result,nums,list,level + 1);
            // //清除前面操作
            // list.remove(list.size() - 1);

            //优化，用一个boolean数组来记录是否使用过
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                helper(result,nums,list,level + 1,used);
                list.remove(level);
                used[i] = false;
            }
        }
    }
}
