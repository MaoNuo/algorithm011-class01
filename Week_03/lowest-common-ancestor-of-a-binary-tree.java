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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //终止条件：当前节点为目标节点或者为叶子节点
        if (root == null || root == p || root == q) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }

        //当前操作，左右子树向下递归，分析
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //有以下几种情况
        //1,两边子树返回的皆为null，则该点不是两点的公共祖先
        if (left == null && right == null) { return null; }
        //2.一边返回为null，另一边不是，说明该点是其中一个点的祖先，公共祖先还在上面
        if (left == null || right == null) {
            return left == null ? right : left;
        }
        //3.两边子树返回均不为null，说明该点为最近公共祖先，返回该点
        return root;
    }
}
