package cn.guosgbin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Dylan Kwok
 * @date 2022-06-01 22:33:37
 */
public class MaximumBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumBinaryTree().new Solution();
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
         * 递归
         *
         * 入参和返回值：没有返回值，入参是 左边的数组，和右边的数组，和中间的结点
         * 出口是：中间的结点是null
         * 单层逻辑：首先找出两个数组吧，找出最大值和左右数组
         */
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return constructMaximumBinaryTree(nums, 0, nums.length);
        }

        public TreeNode constructMaximumBinaryTree(int[] nums, int leftIndex, int rightIndex) {
            if (rightIndex - leftIndex < 1) {
                // 没有元素了
                return null;
            }
            if (rightIndex - leftIndex == 1) {
                // 只有一个元素了
                return new TreeNode(nums[leftIndex]);
            }

            // 找出最大值的索引
            int max = nums[leftIndex];
            int maxIndex = leftIndex;
            for (int i = leftIndex + 1; i < rightIndex; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                    maxIndex = i;
                }
            }

            TreeNode root = new TreeNode(max);
            // 根据maxIndex划分左右子树
            root.left = constructMaximumBinaryTree(nums, leftIndex, maxIndex);
            root.right = constructMaximumBinaryTree(nums, maxIndex + 1, rightIndex);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}