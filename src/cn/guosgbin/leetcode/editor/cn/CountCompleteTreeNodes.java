package cn.guosgbin.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * @author Dylan Kwok
 * @date 2022-04-24 23:32:06
 */
public class CountCompleteTreeNodes{
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
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
//     * 没有使用完全二叉树的特性
//     * 迭代法 -> 层次遍历
//     * 时间复杂度:O(n)
//     * 空间复杂度:O(n)
//     */
//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        int size = 0;
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            size++;
//            if (node.left != null) {
//                queue.offer(node.left);
//            }
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
//        }
//        return size;
//    }

    /**
     * 没有使用完全二叉树的特性
     * 递归
     *
     * 参数和返回值：结点，返回个数
     * 出口：结点为 null
     * 单层递归的逻辑：先求它的左子树的节点数量，再求的右子树的节点数量，最后取总和再加一
     *              （加1是因为算上当前中间节点）就是目前节点为根节点的节点数量。
     *
     * 时间复杂度:O(n)
     * 空间复杂度:O(logn)
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}