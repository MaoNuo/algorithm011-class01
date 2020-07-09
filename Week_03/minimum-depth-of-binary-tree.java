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
    public int minDepth(TreeNode root) {
        //同最大深度
        if (root == null) return 0;
        //叶子节点，返回1
        if (root.left == null && root.right == null) return 1;
        //如果一边子树为空，则需要返回另一边
        if (root.left == null || root.right == null) {
            return Math.max(minDepth(root.left),minDepth(root.right)) + 1;
        }
        //两边子树都不为空，返回较小一边
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
