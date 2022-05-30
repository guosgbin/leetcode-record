package cn.guosgbin.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author Dylan Kwok
 * @date 2022-05-13 00:11:21
 */
public class PathSum{
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
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
//     * 递归
//     *
//     * 方法的入参和返回值：  入参是 结点和路径和， 返回值是 boolean
//     * 退出条件：结点是 null
//     * 单层逻辑：
//     */
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return false;
//        }
//        targetSum = targetSum - root.val;
//        if (root.left == null && root.right == null) {
//            // 找到叶子结点了
//            return targetSum == 0;
//        }
//
//        if (root.left != null) {
//            boolean left = hasPathSum(root.left, targetSum);
//            if (left) {
//                return true;
//            }
//        }
//        if (root.right != null) {
//            boolean right = hasPathSum(root.right, targetSum);
//            if (right) {
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * 迭代
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        nodeStack.push(root);
        sumStack.push(root.val);

        while (!nodeStack.isEmpty()) {
            int size = nodeStack.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = nodeStack.pop();
                Integer sum = sumStack.pop();
                if (node.right == null && node.left == null && sum == targetSum) {
                    return true;
                }

                if (node.left != null) {
                    nodeStack.push(node.left);
                    sumStack.push(sum + node.left.val);
                }
                if (node.right != null) {
                    nodeStack.push(node.right);
                    sumStack.push(sum + node.right.val);

                }
            }
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}