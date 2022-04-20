package cn.guosgbin.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Dylan Kwok
 * @date 2022-04-20 22:00:02
 */
public class SameTree{
    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();
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
//     * 迭代法
//     *
//     * 节点为空的情况
//     *      1.左节点为空，右节点不为空，返回 false
//     *      2.左节点不为空，右节点为空，返回 false
//     *      3.左节点和右节点都为空，返回 true
//     * 节点不为空的情况
//     *      1. 左节点和右节点都不为空，但是值不相等，返回 false
//     *
//     *
//     */
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.offer(p);
//        queue.offer(q);
//        while (!queue.isEmpty()) {
//            TreeNode leftTreeNode = queue.poll();
//            TreeNode rightTreeNode = queue.poll();
//            if (leftTreeNode == null && rightTreeNode == null) {
//                continue;
//            }
////            if (leftTreeNode == null && rightTreeNode != null) {
////                return false;
////            }
////            if (leftTreeNode != null && rightTreeNode == null) {
////                return false;
////            }
////            if (leftTreeNode != null && rightTreeNode != null && leftTreeNode.val != rightTreeNode.val) {
////                return false;
////            }
//            // 上面的三个判断省略成下面的
//            if (leftTreeNode == null || rightTreeNode == null || leftTreeNode.val != rightTreeNode.val) {
//                return false;
//            }
//
//            // 走到此处，说明 左右树的结点不为空，且值相等，需要继续判断后面的结点
//            queue.offer(leftTreeNode.left);
//            queue.offer(rightTreeNode.left);
//            queue.offer(leftTreeNode.right);
//            queue.offer(rightTreeNode.right);
//        }
//        return true;
//    }

    /**
     * 递归法
     *
     * 递归的参数和返回值：参数就是两个结点啦，返回值就是boolean啦
     * 递归的出口
     *      节点为空的情况
     *           1.左节点为空，右节点不为空，返回 false
     *           2.左节点不为空，右节点为空，返回 false
     *           3.左节点和右节点都为空，返回 true
     *      节点不为空的情况
     *           1. 左节点和右节点都不为空，但是值不相等，返回 false
     *
     *  每次递归做什么，判断两个结点是否相等
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
//        if (p == null && q != null) {
//            return false;
//        }
//        if (p != null && q == null) {
//            return false;
//        }
//        if (p != null && q != null && p.val != q.val) {
//            return false;
//        }
        // 上面的三个判断省略成下面的
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // 左子结点是否相等
        boolean leftSame = isSameTree(p.left, q.left);
        boolean rightSame = isSameTree(p.right, q.right);
        return leftSame && rightSame;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}