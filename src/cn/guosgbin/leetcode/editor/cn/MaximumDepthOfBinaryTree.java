package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayDeque;

/**
 * @author Dylan Kwok
 * @date 2022-04-14 23:14:51
 */
public class MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
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
//     * 最大深度 层次遍历
//     */
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//
//        // 层数
//        int floor = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size > 0) {
//                TreeNode node = queue.poll();
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//                size--;
//            }
//            // 每层的
//            floor++;
//        }
//        return floor;
//    }

    /**
     * 最大深度 递归法
     *
     * 使用中序遍历，返回最大深度值
     *
     * 参数值和返回值：
     * 递归的出口：结点为空
     * 每次递归的方法内做什么：
     */
    public int maxDepth(TreeNode root) {
        return getdepth(root);
    }

    /**
     * 中序遍历
     */
    public int getdepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftdepth = getdepth(node.left); // 左
        int rightdepth = getdepth(node.right); // 右
        int depth = 1 + Math.max(leftdepth, rightdepth); // 中
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}