package cn.guosgbin.leetcode.editor.cn;
 /**
  * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
  *
 * @author Dylan Kwok
 * @date 2022-06-19 20:36:33
 */
public class LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
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
     * 迭代法，找到最近公共祖先
     *
     * 既然是找功最近的公共祖先，则从树的底部开始遍历，也就是 左右中，也就是后序遍历
     *
     * 方法的入参和返回值：返回找到的结点，因为需要判断左右节点，所以需要判断左右节点是否是返回值
     * 递归出口：首先判断的是叶子结点，出口就是叶子结点，或者是找到了一个数
     * 单层逻辑：
     *      假如是叶子结点，直接退出
     *      假如是两个结点中的一个，直接退出， 假如当前结点是一个
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 假如找到叶子结点，找到p或者q的当中一个，立刻返回
        if (root == null || root == p || root == q) {
            return root;
        }

        // 后序遍历 左右中
        // 左
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        // 右
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        // 中间处理
       if (leftNode != null && rightNode != null) {
           return root;
       }
       return leftNode != null ? leftNode : rightNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}