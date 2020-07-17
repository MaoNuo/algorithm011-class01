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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) { queue.add(root); }
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) { queue.add(node.left); }
                if (node.right != null) { queue.add(node.right); }
                if (node.val > max) { max = node.val; }
            }
            res.add(max);
        }
        return res;
    }
}
