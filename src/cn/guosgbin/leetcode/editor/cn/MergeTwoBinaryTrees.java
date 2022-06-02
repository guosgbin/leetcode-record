package cn.guosgbin.leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/merge-two-binary-trees/
 *
 * @author Dylan Kwok
 * @date 2022-06-02 23:07:12
 */
public class MergeTwoBinaryTrees{
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
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
//     * 递归 -> 自己第一次写的垃圾版
//     *
//     * 入参和返回值：两棵树的两个结点，返回值就是新的结点
//     * 递归出口：两个结点都是空
//     * 单层逻辑： 首先创建一个新节点将两个结点的值相加，假如左右结点存在，分别调用
//     */
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        if (root1 == null && root2 == null) {
//            return null;
//        }
//
//        TreeNode node = new TreeNode();
//        int val1 = root1 != null ? root1.val : 0;
//        int val2 = root2 != null ? root2.val : 0;
//        node.val = val1 + val2;
//
//        if (root1 == null && root2 != null) {
//            node.left = mergeTrees(null, root2.left);
//            node.right = mergeTrees(null, root2.right);
//        } else if (root1 != null && root2 == null) {
//            node.left = mergeTrees(root1.left, null);
//            node.right = mergeTrees(root1.right, null);
//        } else {
//            node.left = mergeTrees(root1.left, root2.left);
//            node.right = mergeTrees(root1.right, root2.right);
//        }
//        return node;
//    }


//    /**
//     * 递归
//     *
//     * 入参和返回值：两棵树的两个结点，返回值就是新的结点
//     * 递归出口：两个结点都是空
//     * 单层逻辑： 首先创建一个新节点将两个结点的值相加，假如左右结点存在，分别调用
//     */
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        if (root1 == null) {
//            // 如果t1为空，合并之后就应该是t2,如果t2也为NULL也无所谓，合并之后就是NULL
//            return root2;
//        }
//        if (root2 == null) {
//            // 如果t2为空，合并之后就应该是t1,如果t1也为NULL也无所谓，合并之后就是NULL
//            return root1;
//        }
//
//        // 走到此处，root1和root2都不为null
//        TreeNode node = new TreeNode(root1.val + root2.val);
//        node.left = mergeTrees(root1.left, root2.left);
//        node.right = mergeTrees(root1.right, root2.right);
//        return node;
//    }


    /**
     * 迭代法 - 可以，但是不好理解
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            // 此时两个节点一定不为空，val相加
            node1.val = node1.val + node2.val;
            // 如果两棵树左节点都不为空，加入队列
            if (node1.left != null && node2.left != null) {
                queue.offer(node1.left);
                queue.offer(node2.left);
            }
            // 如果两棵树右节点都不为空，加入队列
            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            // 若node1的左节点为空，直接赋值
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            // 若node2的左节点为空，直接赋值
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}