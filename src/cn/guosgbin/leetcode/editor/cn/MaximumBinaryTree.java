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
         */
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return constructMaximumBinaryTree(nums, 0, nums.length);
        }

        public TreeNode constructMaximumBinaryTree(int[] nums, int leftIndex, int rightIndex) {
            if (rightIndex == leftIndex) {
                // 没有元素了
                return null;
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
            // 左闭右开：[left, maxValueIndex)
            root.left = constructMaximumBinaryTree(nums, leftIndex, maxIndex);
            // 左闭右开：[maxValueIndex + 1, right)
            root.right = constructMaximumBinaryTree(nums, maxIndex + 1, rightIndex);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}