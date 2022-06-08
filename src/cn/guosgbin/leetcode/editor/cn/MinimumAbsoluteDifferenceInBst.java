package cn.guosgbin.leetcode.editor.cn;

import java.util.Stack;

/**
  * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
  *
 * @author Dylan Kwok
 * @date 2022-06-08 22:04:20
 */
public class MinimumAbsoluteDifferenceInBst{
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
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
//     * 递归法
//     *
//     * 在二叉线索树上求什么最值啊，差值之类的，就把他想成在一个有序数组上求最值，求差值，这样就简单多了
//     * 有序的话，就是中序遍历了
//     *
//     * 方法入参和返回值：结点，返回值是
//     * 递归出口：结点为null
//     * 单层：
//     */
//
//    private TreeNode prev = null; // 用于记录上一个结点
//    private int min = Integer.MAX_VALUE;
//
//    public int getMinimumDifference(TreeNode root) {
//        traversal(root);
//        return min;
//    }
//
//    private void traversal(TreeNode root) {
//        if (root.left != null) {
//            traversal(root.left);
//        }
//
//        if (prev != null) {
//            int diff = root.val - prev.val;
//            if (diff < min) {
//                min = diff;
//            }
//        }
//        // 记录上一个结点为当前结点
//        prev = root;
//        if (root.right != null) {
//            traversal(root.right);
//        }
//    }


    /**
     * 迭代法
     *
     * 中序遍历
     */
    public int getMinimumDifference(TreeNode root) {
        TreeNode prev = null; // 用于记录上一个结点
        int min = Integer.MAX_VALUE;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 先找到最左的
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 此时已经是左的
            TreeNode node = stack.pop();
            if (prev != null) {
                min = Math.min(min, node.val - prev.val);
            }
            // 记录上一个结点
            prev = node;
            cur = node.right;
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}