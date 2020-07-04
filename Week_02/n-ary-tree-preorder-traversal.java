/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.*;

class Solution {
//    //递归
//    public List<Integer> preorder(Node root) {
//        List<Integer> ans = new ArrayList<>();
//        backtrack(ans,root);
//        return ans;
//    }
//
//    private void backtrack(List<Integer> ans, Node root) {
//        if (root == null) {
//            return ;
//        }
//        ans.add(root.val);
//        for (Node node : root.children) {
//            backtrack(ans,node);
//        }
//    }

    public List<Integer> preorder(Node root) {
        //迭代
        /*
            使用stack能够模拟前序的输出模式
            但是由于stack是先入后出，所以在对子节点的添加时，需要颠倒之后再添加
         */
        List<Integer> ans = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        if (root != null) {
            stack.addLast(root);
        }
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            ans.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.addLast(child);
            }
        }
        return ans;
    }
}
