import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
//    public List<Integer> inorderTraversal(TreeNode root) {
//        //递归
//        List<Integer> ans = new ArrayList<>();
//        backtrack(ans,root);
//        return ans;
//    }
//
//    private void backtrack(List<Integer> ans, TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        backtrack(ans,root.left);
//        ans.add(root.val);
//        backtrack(ans,root.right);
//    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        //基于栈的遍历
//        List<Integer> ans = new ArrayList<>();
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        TreeNode cur = root;
//        while (cur != null || !stack.isEmpty()) {
//            while (cur != null) {
//                stack.addLast(cur);
//                cur = cur.left;
//            }
//            cur = stack.removeLast();
//            ans.add(cur.val);
//            cur = cur.right;
//        }
//        return ans;
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        //莫里斯中序遍历
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        //开始遍历
        while (cur != null) {
            //当前节点没有左子节点，则将当前节点加入ans，并转向右子节点
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            }
            //当前节点存在左子树，则需要找到当前左子树的最右叶子节点
            //找到的最右叶子节点必为当前左子树中最后遍历到的节点
            //所以在遍历完该最右叶子节点后，根据中序遍历的定义，需要遍历到原根节点
            //由于是叶子节点，所以将根节点转接到叶子节点的右侧，可以完成中序遍历
            else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                //如果当前叶子节点的右节点为空，则将根节点接到右侧
                if (pre.right == null) {
                    pre.right = cur;
                    //以当前节点的左子树为新的根节点，进入下一次循环
                    cur = cur.left;
                }
                //如果当前叶子节点的右节点与根节点相等，则说明原树结构已经更改过，需要恢复
                if (pre.right == cur) {
                    pre.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
}