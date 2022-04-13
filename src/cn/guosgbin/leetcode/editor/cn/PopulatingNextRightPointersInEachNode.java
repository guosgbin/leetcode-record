package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan Kwok
 * @date 2022-04-13 23:07:52
 */
public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        /**
         * 层次遍历
         */
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                Node prevNode = null;
                while (size > 0) {
                    Node node = queue.poll();
                    if (prevNode != null) {
                        prevNode.next = node;
                    }
                    prevNode = node;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    size--;
                }
            }
            return root;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}