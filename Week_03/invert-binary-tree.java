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
    // public TreeNode invertTree(TreeNode root) {
    //     //终止条件 : 当前节点为空
    //     if (root == null) return root;

    //     //当前层任务 ：交换左右子树
    //     TreeNode temp = root.left;
    //     root.left = root.right;
    //     root.right = temp;

    //     //递归到下一层 ： 左右子树分别翻转
    //     root.left = invertTree(root.left);
    //     root.right = invertTree(root.right);

    //     return root;
    // }

    public TreeNode invertTree(TreeNode root) {
        //迭代，使用队列进行遍历
        //对于所有不为空的节点，交换其左右两个子树，并将不为空的子树放入队列
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }
}
