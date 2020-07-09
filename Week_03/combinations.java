class Solution {
    // 结果 ：未去重
    // public List<List<Integer>> combine(int n, int k) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     List<Integer> list = new ArrayList<>();
    //     boolean[] used = new boolean[n + 1];
    //     helper(result, list, n, k, 0, used);
        
    //     return result;
    // }

    // private void helper(List<List<Integer>> result, List<Integer> list, int n, int k, int level, boolean[] used) {
    //     //终止条件 ： 组合中数量达到k
    //     if (level == k) {
    //         result.add(new ArrayList<>(list));
    //         return;
    //     }

    //     //当前层，添加一个没有使用过的数
    //     for (int i = 1; i <= n; i++) {
    //         if (!used[i]) {
    //             list.add(i);
    //             used[i] = true;
    //             //进入下一层
    //             helper(result, list, n, k, level + 1, used);
    //             //清除当前层的操作
    //             list.remove(level);
    //             used[i] = false;
    //         }
    //     }
    // }

    //去重办法 ：记录上一次添加的数，下一次从比这个数大的数开始遍历
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(result, list, n, k, 0, 0);
        
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int n, int k, int level, int last) {
        //终止条件 ： 组合中数量达到k
        if (level == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        //当前层，添加一个没有使用过的数
        for (int i = last + 1; i <= n; i++) {
           list.add(i);
           helper(result, list, n, k, level + 1, i);
           list.remove(level);
        }
    }
}
