package cn.guosgbin.leetcode.editor.cn;

import java.util.*;

/**
 * @author Dylan Kwok
 * @date 2022-05-31 22:08:14
 */
public class PathSumIi{
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
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

    public List<List<Integer>> result = new ArrayList<>();

    /**
     * 迭代
     *
     * 方法的入参和返回值：  入参：结点，目标和，集合
     * 递归出口：结点为 null
     * 单层逻辑：找到叶子结点和为 targetSum的，添加到集合中，递归左右子结点
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<Integer> path = new LinkedList<>();
        pathSum(root, targetSum, path);
        return result;
    }

    private void pathSum(TreeNode node, int targetSum, LinkedList<Integer> path) {
        if (node == null) {
            return;
        }

        targetSum = targetSum - node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
        }

        if (node.left != null) {
            pathSum(node.left, targetSum, path);
            path.removeLast();
        }

        if (node.right != null) {
            pathSum(node.right, targetSum, path);
            path.removeLast();
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}