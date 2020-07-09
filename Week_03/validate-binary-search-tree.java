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
    //错误
    //原因，只判断了左节点和右节点，比如某子树的右节点可能大于祖先的值，没有考虑进去，导致错误
    // public boolean isValidBST(TreeNode root) {
    //     //递归
    //     //空树返回真
    //     if (root == null) {
    //         return true;
    //     }
    //     //1.终止条件 : 当前节点为叶子节点
    //     if (root.left == null && root.right == null) {
    //         return true;
    //     }
    //     //1.2.终止条件2 : 当前节点为非叶子节点，不符合二叉搜索树的结构
    //     if (root.left != null && root.left.val >= root.val) {
    //         return false;
    //     }
    //     if (root.right != null && root.right.val <= root.val) {
    //         return false;
    //     }

    //     //当前层操作 ：无
    //     //进入下一层
    //     boolean left = isValidBST(root.left);
    //     boolean right = isValidBST(root.right);

    //     return left && right;
    // }

    //改进 : 设定上下边界
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer upper, Integer lower) {
        //终止条件 ： 当前节点为空
        if (root == null) return true;

        //终止条件 ： 当前节点值不在上下界范围内
        if (upper != null && root.val >= upper) return false;
        if (lower != null && root.val <= lower) return false;

        //下一层递归，更改上界
        if (!helper(root.left, root.val, lower)) return false;
        if (!helper(root.right, upper, root.val)) return false;

        return true;
    }
}
