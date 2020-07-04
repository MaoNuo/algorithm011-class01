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
//    //递归
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        backtrack(ans,root);
//        return ans;
//    }
//
//    private void backtrack(List<Integer> ans, TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        ans.add(root.val);
//        backtrack(ans,root.left);
//        backtrack(ans,root.right);
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        //迭代
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) {
            stack.addLast(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            ans.add(node.val);
            if (node.right != null) stack.addLast(node.right);
            if (node.left != null) stack.addLast(node.left);
        }
        return ans;
    }
}