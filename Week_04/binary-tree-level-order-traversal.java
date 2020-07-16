/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     //bfs
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (root != null) { queue.add(root); }
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         List<Integer> list = new ArrayList<>();
    //         for (int i = 0; i < size; i++) {
    //             TreeNode node = queue.poll();
    //             list.add(node.val);
    //             if (node.left != null) { queue.add(node.left); }
    //             if (node.right != null) { queue.add(node.right); }
    //         }
    //         res.add(list);
    //     }
    //     return res;
    // }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //dfs
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        travel(root, 0, res);
        return res;
    }

    private void travel(TreeNode root, int level, List<List<Integer>> res) {
        if (level == res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        if (root.left != null) {
            travel(root.left, level + 1, res);
        }
        if (root.right != null) {
            travel(root.right, level + 1, res);
        }
    }
}
