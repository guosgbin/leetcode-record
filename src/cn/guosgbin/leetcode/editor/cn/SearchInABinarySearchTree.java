package cn.guosgbin.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dylan Kwok
 * @date 2022-06-04 23:00:29
 */
public class SearchInABinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new SearchInABinarySearchTree().new Solution();
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
//     * 方法的入参和返回值：
//     * 递归的出口：结点为null
//     * 单层逻辑：找出值相等的结点，如果相等直接返回。
//     *          如果不相等，假如要找的结点大于当前结点，就递归右节点，
//     *                    假如要找的结点小于当前结点，就递归左节点
//     */
//    public TreeNode searchBST(TreeNode root, int val) {
//        if (root == null) {
//            return null;
//        }
//
//        if (root.val == val) {
//            return root;
//        }
//
//        TreeNode node = null;
//        if (val > root.val && root.right != null) {
//            node = searchBST(root.right, val);
//        }
//
//        if (val < root.val && root.left != null) {
//            node = searchBST(root.left, val);
//        }
//        return node;
//    }


    /**
     * 迭代法
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return node;
            }else if (val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}