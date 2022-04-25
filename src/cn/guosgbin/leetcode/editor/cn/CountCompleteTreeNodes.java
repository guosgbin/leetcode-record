package cn.guosgbin.leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

/**
 * @author Dylan Kwok
 * @date 2022-04-24 23:32:06
 */
public class CountCompleteTreeNodes{
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
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
//     * 没有使用完全二叉树的特性
//     * 迭代法 -> 层次遍历
//     * 时间复杂度:O(n)
//     * 空间复杂度:O(n)
//     */
//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        int size = 0;
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            size++;
//            if (node.left != null) {
//                queue.offer(node.left);
//            }
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
//        }
//        return size;
//    }

//    /**
//     * 没有使用完全二叉树的特性
//     * 递归
//     *
//     * 参数和返回值：结点，返回个数
//     * 出口：结点为 null
//     * 单层递归的逻辑：先求它的左子树的节点数量，再求的右子树的节点数量，最后取总和再加一
//     *              （加1是因为算上当前中间节点）就是目前节点为根节点的节点数量。
//     *
//     * 时间复杂度:O(n)
//     * 空间复杂度:O(logn)
//     */
//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int leftCount = countNodes(root.left);
//        int rightCount = countNodes(root.right);
//        return leftCount + rightCount + 1;
//    }


    /**
     * 使用完全二叉树的特性
     * https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/c-san-chong-fang-fa-jie-jue-wan-quan-er-cha-shu-de/
     *
     * 思路：完全二叉树，有一个规律就是，对于一个结点的左右子树来分析
     *      左子树的深度和右子树的深度一样 -> 说明左子树为满二叉树
     *      左子树的深度比右子树的深度大 -> 说明右子树为满二叉树
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子树的深度
        int leftDepth = getDepth(root.left);
        // 右子树的深度
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {
            // 说明左子树是满二叉树
            // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            // 说明右子树是满二叉树
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    /**
     * 获取 node 结点的深度
     * 直接遍历左节点即可，因为完全二叉树
     */
    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}