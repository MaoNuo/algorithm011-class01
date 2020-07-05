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

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

class Solution {
//    public List<Integer> postorder(Node root) {
//        //递归
//        List<Integer> ans = new ArrayList<>();
//        backtrack(ans,root);
//
//        return ans;
//    }
//
//    private void backtrack(List<Integer> ans, Node root) {
//        if (root == null) {
//            return;
//        }
//        for (Node child : root.children) {
//            backtrack(ans,child);
//        }
//        ans.add(root.val);
//    }

    public List<Integer> postorder(Node root) {
        //迭代，使用栈
        /*
            原理：后序遍历实则是先从则向右遍历所有子节点，最后遍历父节点
                 如果反过来思考，则是最先遍历父节点，再从右向左遍历所有子节点
                 这样就可以使用stack的性质，实行类似与先序遍历的遍历，最后将返回值反转一下即可
         */

        List<Integer> ans = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        if (root != null) {
            stack.addLast(root);
        }
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            ans.add(node.val);
            for (Node child : node.children) {
                stack.addLast(child);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}