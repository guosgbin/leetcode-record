package cn.guosgbin.leetcode.editor.cn;
 /**
  * https://leetcode.cn/problems/insert-into-a-binary-search-tree/
  *
 * @author Dylan Kwok
 * @date 2022-06-21 22:09:33
 */
public class InsertIntoABinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();
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
     * 二叉搜索树中的插入操作
     *
     * 二叉搜索树是有序的， 左中右
     *
     *       10
     *    3      14
     *  1   5
     *
     *  单层逻辑： 判断值 是大于当前结点还是小于当前结点，
     *          大于： 往右边找
     *          小于： 往左边找
     *          遇到空结点就直接插入
     *
     *
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }

        // 左
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        // 右
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}