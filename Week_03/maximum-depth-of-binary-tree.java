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
    public int maxDepth(TreeNode root) {
        //终止条件 ： 当前节点为空，返回0
        if (root == null) return 0;

        //当前层 ： 左右子树得到的深度分别加1，求出最大值并返回
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int ans = Math.max(left,right) + 1;
        return ans;
    }
}
