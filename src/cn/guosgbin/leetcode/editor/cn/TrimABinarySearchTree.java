package cn.guosgbin.leetcode.editor.cn;
 /**
 * @author Dylan Kwok
 * @date 2022-06-25 21:01:12
 */
public class TrimABinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new TrimABinarySearchTree().new Solution();
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
     * 方法的入参和返回值：
     * 递归出口：叶子结点
     * 单层逻辑：
     *      假如当前结点的值小于 low
     *          直接将当前结点的左结点的右节点 放到当前结点的左节点
     *      假如当前结点的值大于 high
     *          直接将当前结点的右节点的左节点 放到当前结点的右节点
     *
     *      假如当前结点没有子结点，直接删除
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low,high);
        root.right = trimBST(root.right, low,high);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}