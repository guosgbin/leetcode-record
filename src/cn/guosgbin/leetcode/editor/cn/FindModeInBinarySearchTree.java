package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan Kwok
 * @date 2022-06-09 23:10:56
 */
public class FindModeInBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
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
     * 递归法
     *
     * 中序遍历
     */
    private TreeNode prev = null;
    private List<Integer> result = new ArrayList<>();
    private int maxCount = 0;
    private int count = 0;
    public int[] findMode(TreeNode root) {
        searchBST(root);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void searchBST(TreeNode node) {
        if (node == null) {
            return;
        }

        // 左
        if (node.left != null) {
            searchBST(node.left);
        }

        // 中
        if (prev == null) {
            // 第一个元素
            count = 1;
        } else if (prev.val == node.val) {
            // 当前结点和前一个结点的值相等
            count++;
        } else {
            // 当前结点和前一个结点不相等
            count = 1;
        }

        prev = node;

        if (count > maxCount) {
            maxCount = count;
            // 清空集合
            result.clear();
            result.add(node.val);
        } else if (count == maxCount) {
            // 找到相同 count 的众数
            result.add(node.val);
        }

        // 右
        if (node.right != null) {
            searchBST(node.right);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}