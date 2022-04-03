package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Dylan Kwok
 * @date 2022-04-01 22:09:15
 */
public class BinaryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
   }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 后续遍历
     *
     * 入参：结点
     * 出口：结点为null
     * 每次调用做什么，后续遍历 左右中
     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        traversal(root, list);
//        return list;
//    }

    public void traversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traversal(node.left, list);
        traversal(node.right, list);
        list.add(node.val);
    }

    /**
     * 后续遍历迭代法
     *
     * 后续遍历是 左右中
     * 前序遍历是 中左右
     *
     * 先按照 中右左 来遍历得到list，再将集合反转就是  左右中，也就是后续遍历了
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}