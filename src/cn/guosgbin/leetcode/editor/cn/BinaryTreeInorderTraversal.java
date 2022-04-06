package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Dylan Kwok
 * @date 2022-04-01 22:17:20
 */
public class BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        traversal(root, list);
//        return list;
//    }

    public void traversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traversal(node.left, list);
        list.add(node.val);
        traversal(node.right, list);

    }

//    /**
//     * 中序遍历迭代法
//     *
//     */
//    public List<Integer> inorderTraversal (TreeNode root){
//        Stack<TreeNode> stack = new Stack<>();
//        List<Integer> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//        TreeNode cur = root;
//        while (cur != null || !stack.isEmpty()) {
//            if (cur != null) {
//                // 表示左子结点有数据
//                // 添加到栈
//                stack.add(cur);
//                cur = cur.left;
//            } else {
//                // 说明当前结点没有左子结点了，添加元素
//                TreeNode node = stack.pop();
//                list.add(node.val);
//                // 遍历右子树
//                cur = node.right;
//            }
//        }
//        return list;
//    }



    /**
     * 中序遍历
     * 迭代法 2
     * 使用栈的结构，先进右节点，再进左节点，这样出栈的顺序就是 左节点在前了
     *
     * 统一套路
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur != null) {
                // 前序遍历 -> 左中右 -> 那么入栈就是 右中左
                TreeNode node = stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                stack.pop();
                TreeNode node = stack.pop();
                list.add(node.val);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}