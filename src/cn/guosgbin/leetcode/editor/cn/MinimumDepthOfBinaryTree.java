package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayDeque;

/**
 * @author Dylan Kwok
 * @date 2022-04-14 23:31:49
 */
public class MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
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
//     * 最小深度 层次遍历
//     */
//    public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//
//        int floor = 1;
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
//                if (node.right == null && node.left == null) {
//                    // 叶子结点
//                   return floor;
//                }
//                size--;
//            }
//            floor++;
//        }
//
//        return 0;
//    }


    /**
     * 最小深度 递归
     *
     * minDepth = Math.min(left, right);
     *
     * 分析：
     * 递归的参数和返回值：参数是 TreeNode，返回值是最小深度
     * 确认终止条件：结点为 null，返回 0
     * 确认单层递归的逻辑：找到左右结点最小深度的，是0的不算
     */
    public int minDepth(TreeNode root) {
        return getDepth(root);
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left); // 左
        int rightDepth = getDepth(node.right); // 右

        // 左节点为空则返回右节点的深度
        if (node.left == null && node.right != null) {
            return rightDepth + 1;
        }
        // 右节点为空则返回左节点的深度
        if (node.left != null && node.right == null) {
            return leftDepth + 1;
        }
        return Math.min(rightDepth, leftDepth) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}