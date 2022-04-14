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
    /**
     * 最小深度 层次遍历
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int floor = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.right == null && node.left == null) {
                    // 叶子结点
                   return floor;
                }
                size--;
            }
            floor++;
        }

        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}