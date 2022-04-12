package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan Kwok
 * @date 2022-04-12 22:08:30
 */
public class NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
   }

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

    //leetcode submit region begin(Prohibit modification and deletion)
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

class Solution {
    /**
     * 层次遍历
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> itemList = new ArrayList<>();
            while (size > 0) {
                Node node = queue.poll();
                itemList.add(node.val);
                // 遍历子节点，添加到队列
                for (Node child : node.children) {
                    queue.offer(child);
                }
                size--;
            }
            result.add(itemList);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}