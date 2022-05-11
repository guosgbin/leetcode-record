package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @author Dylan Kwok
 * @date 2022-05-11 22:55:49
 */
public class FindBottomLeftTreeValue{
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
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
//     * 找到最后一行最左边的结点
//     * 层次遍历
//     */
//    public int findBottomLeftValue(TreeNode root) {
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int bottomLeftValue = root.val;
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            int index = 0;
//            while (index < size) {
//                TreeNode poll = queue.poll();
//                if (poll.left != null) {
//                    queue.offer(poll.left);
//                }
//                if (poll.right != null) {
//                    queue.offer(poll.right);
//                }
//                if (index == 0) {
//                    bottomLeftValue = poll.val;
//                }
//                index++;
//            }
//        }
//        return bottomLeftValue;
//    }


    /**
     * 递归法
     *
     *
     */
    private int maxDeep = -1;
    private int bottomLeftValue = 0;
    public int findBottomLeftValue(TreeNode root) {
        bottomLeftValue = root.val;
        findLeftValue(root,0);
        return bottomLeftValue;
    }

    private void findLeftValue (TreeNode node,int deep) {
        if (node == null) {
            return;
        }
        // 条件成立，找到叶子结点
        if (node.left == null && node.right == null) {
            if (deep > maxDeep) {
                bottomLeftValue = node.val;
                // 赋值最大深度
                maxDeep = deep;
            }
        }
        if (node.left != null) {
            findLeftValue(node.left, deep + 1);
        }
        if (node.right != null) {
            findLeftValue(node.right, deep + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}









