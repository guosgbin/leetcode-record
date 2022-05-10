package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Stack;

/**
  * https://leetcode.cn/problems/sum-of-left-leaves/
  *
 * @author Dylan Kwok
 * @date 2022-05-09 23:44:42
 */
public class SumOfLeftLeaves{
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
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
     * 左叶子之和，那么首先需要知道什么时候是左叶子
     * 左叶子：叶子结点没有左右子结点，且自己是父结点的左子结点
     */

//    /**
//     * 递归法
//     *
//     * 递归函数的参数和返回值：参数是结点对象，返回值是左叶子的和
//     * 终止条件：结点为 null
//     * 单层逻辑：校验结点是否是左叶子节点，累加左子节点的值
//     */
//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int leftValue = sumOfLeftLeaves(root.left); // 左
//        int rightValue = sumOfLeftLeaves(root.right); // 右
//
//        // 中
//        int midValue = 0;
//        if (root.left != null
//                && root.left.left == null && root.left.right == null) {
//            midValue = root.left.val;
//        }
//        return leftValue + rightValue + midValue;
//    }

    /**
     * 迭代法
     *
     * 前中后序遍历，找到所有的左叶子结点即可
     * 本次采用中序遍历
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> queue = new Stack<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            if (pop != null) {
                // 右
                if (pop.right != null) {
                    queue.add(pop.right);
                }
                // 中
                queue.push(pop);
                queue.push(null);

                // 左
                if (pop.left != null) {
                    queue.add(pop.left);
                }
            } else {
                TreeNode node = queue.pop();
                if (node.left != null
                        && node.left.left == null && node.left.right == null) {
                    // 找到左叶子结点
                    sum += node.left.val;
                }
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}