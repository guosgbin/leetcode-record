package cn.guosgbin.leetcode.editor.cn;
 /**
 * @author Dylan Kwok
 * @date 2022-06-20 22:05:35
 */
public class LowestCommonAncestorOfABinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
   }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
   
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    /**
     * 二叉搜索树的最近公共祖先
     *
     * 迭代法
     *
     * 二叉搜索树的特点，对于结点， 左 < 中 < 右
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // 二叉搜索树有序，所以需要找到 [p.val, q.val] 或者 [q.val, p.val] 之间的数就行了
        // 前序遍历 中左右

        if (p.val < root.val && q.val < root.val) {
            // 说明两个节点在 root 的左边
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) {
                return left;
            }
        }

        if (p.val > root.val && q.val > root.val) {
            // 说明两个节点在 root 的右边
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null) {
                return right;
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}