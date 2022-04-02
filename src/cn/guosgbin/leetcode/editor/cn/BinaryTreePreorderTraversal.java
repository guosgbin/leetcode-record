package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author Dylan Kwok
 * @date 2022-03-31 22:45:39
 */
public class BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
     * 前序遍历
     *
     * 递归方法
     * 参数入口：节点,存数据的集合
     * 出口：节点为空
     * 每次递归要做的：读取中间值，递归左边节点，递归右边节点
     *
     * @param root
     * @return
     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        traversal(root, list);
//        return list;
//    }

    public void traversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        traversal(node.left, list);
        traversal(node.right, list);
    }


    /**
     * 前序遍历
     * 迭代法
     * 使用栈的结构，先进右节点，再进左节点，这样出栈的顺序就是 左节点在前了
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}