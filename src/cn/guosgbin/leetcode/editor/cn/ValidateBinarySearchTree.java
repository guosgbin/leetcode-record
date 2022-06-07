package cn.guosgbin.leetcode.editor.cn;

import java.util.Stack;

/**
  * https://leetcode.cn/problems/validate-binary-search-tree/
  *
 * @author Dylan Kwok
 * @date 2022-06-05 20:43:21
 */
public class ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
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
//    /**
//     * 验证二叉搜索树
//     * 递归
//     *
//     * 方法入参和返回值：没有返回值，入参就是结点
//     * 递归出口：结点为null
//     * 单层逻辑：中序遍历，因为需要满足  左节点最小 -> 中结点中间 -> 右节点最大， 不仅仅是判断 中间的比左边大
//     *          而是判断，中序遍历是，结点的大小是递增的
//     *
//     */
//    TreeNode prev = null; // 用来记录前一个节点
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        // 左
//        boolean leftResult = isValidBST(root.left);
//
//        // 中
//        if (prev != null && prev.val >= root.val) {
//            return false;
//        }
//        // 记录前一个结点
//        prev = root;
//
//        // 右
//        boolean rightResult = isValidBST(root.right);
//        return leftResult && rightResult;
//    }


    /**
     * 迭代法
     *
     * 中序遍历，左中右，所以就需要看是否是递增了
     *
     * 已经处理的结点用null标识
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null; // 记录前一个结点


        while (cur != null || !stack.isEmpty()) {
            // 先找到最左边的
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 此时是最左边的
            TreeNode node = stack.pop();
            if (prev != null && prev.val >= node.val) {
                return false;
            }
            // 记录上一个结点
            prev = node;
            cur = node.right;
        }

        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}