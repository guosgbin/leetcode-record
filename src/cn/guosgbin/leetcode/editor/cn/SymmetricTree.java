package cn.guosgbin.leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Dylan Kwok
 * @date 2022-04-18 23:39:03
 */
public class SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
//     */
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        // 添加左右结点
//        queue.offer(root.left);
//        queue.offer(root.right);
//
//        while (!queue.isEmpty()) {
//            TreeNode leftNode = queue.poll();
//            TreeNode rightNode = queue.poll();
//            if (leftNode == null && rightNode == null) {
//                // 左右结点都是空，说明对称
//                continue;
//            }
//
//            // 左节点为空，右节点不为空
//            // 左节点不为空，右节点为空
//            // 左右节点不为空，但是值不一样
////            if (leftNode == null && rightNode != null) {
////                return false;
////            }
////            if (leftNode != null && rightNode == null) {
////                return false;
////            }
////            if (leftNode != null && rightNode != null && leftNode.val != rightNode.val) {
////                return false;
////            }
//            // 上面三个条件可以省略成下面这个
//            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
//                return false;
//            }
//
//            // 添加左节点的左子节点，添加右节点的右子节点
//            queue.offer(leftNode.left);
//            queue.offer(rightNode.right);
//            // 添加左节点的右子节点，添加右节点的左子节点
//            queue.offer(leftNode.right);
//            queue.offer(rightNode.left);
//        }
//        return true;
//    }

    /**
     * 递归法
     *
     * 分析
     * 递归方法的参数：判断的是 左子树节点 和 右子树节点
     * 递归方法的返回值：boolean
     * 递归方法的出口：
     *      节点为空的情况
     *      1.左节点为空，右节点不为空 返回false
     *      2.左节点不为空，右节点为空 返回 false
     *      3.左右结点都是空 返回 true
     *
     *      结点不为空的情况
     *      4.左右节点不为空，但是值不一样 返回 false
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    /**
     * 比较左节点和右节点
     */
    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {
            return false;
        }

        // 此时就是：左右节点都不为空，且数值相同的情况
        // 此时才做递归，做下一层的判断
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}