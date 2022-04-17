package cn.guosgbin.leetcode.editor.cn;
 /**
 * @author Dylan Kwok
 * @date 2022-04-17 23:26:23
 */
public class InvertBinaryTree{
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
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
     * 递归交换左右结点
     */
    public TreeNode invertTree(TreeNode root) {
        invertTree0(root);
        return root;
    }

    /**
     * 每次递归做什么：调换左右结点的值
     * 出口：没有子结点了
     */
    private void invertTree0(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;
        invertTree0(left);
        invertTree0(right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}