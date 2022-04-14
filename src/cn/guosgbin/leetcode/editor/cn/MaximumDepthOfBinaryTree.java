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
    /**
     * 最大深度 层次遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        // 层数
        int floor = 0;
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
                size--;
            }
            // 每层的
            floor++;
        }
        return floor;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}