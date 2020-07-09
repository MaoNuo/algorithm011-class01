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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode helper(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        //1.终止条件：先序遍历中得到的树的大小为0，即start > end
        if (pre_start > pre_end) {
            return null;
        }

        //2.本层操作 ： 从先序遍历中找出该树的根root，并根据其在中序遍历中的位置分开左右子树
        //root坐标：先序遍历中的第一个数，即preorder[pre_start]
        int val = preorder[pre_start];
        TreeNode root = new TreeNode(val);
        //遍历中序，找出其在中序遍历中的下标
        int index = in_start;
        while (index <= in_end) {
            if (inorder[index] == val) { break; }
            index++;
        }
        //左子树的节点个数 : left_amount = index - in_start
        //左子树在先序遍历中的下标范围 ： [pre_start + 1, pre_start + left_amount]
        //左子树在中序遍历中的下标范围 :  [in_start, index - 1]
        int left_amount = index - in_start;
        root.left = helper(preorder, pre_start + 1, pre_start + left_amount, inorder, in_start, index - 1);
        //右子树的节点个数 ： right_amount = in_end - index 
        //右子树在先序遍历中的下标范围 ： [pre_end - right_amount + 1, pre_end]
        //右子树在中序遍历中的下标范围 ： [index + 1, in_end]
        int right_amount = in_end - index;
        root.right = helper(preorder, pre_end - right_amount + 1, pre_end, inorder, index + 1, in_end);

        //构建完成，返回该子树树根
        return root;
    }
}
