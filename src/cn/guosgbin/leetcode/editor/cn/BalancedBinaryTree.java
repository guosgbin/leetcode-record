package cn.guosgbin.leetcode.editor.cn;
 /**
  * https://leetcode-cn.com/problems/balanced-binary-tree/
 * @author Dylan Kwok
 * @date 2022-04-26 23:20:39
 */
public class BalancedBinaryTree{
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
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
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     * 递归法
     *
     * 由底向上
     * 参数和返回值：参数是某个结点，返回结点的高度，假如不是平衡二叉树了则返回-1
     * 递归出口：为空，返回0
     * 单层操作：判断左右子树的高度差是否超过1，假如超过1就说明不是平衡二叉树了
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getDepth(root) != -1;
    }

    /**
     * 获取高度
     */
    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getDepth(node.right);
        if (rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            // 不是平衡二叉树返回 -1
            return -1;
        }
        // 是平衡二叉树，返回高度
        return Math.max(leftDepth , rightDepth) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}