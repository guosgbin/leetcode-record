package cn.guosgbin.leetcode.editor.cn;
 /**
 * @author Dylan Kwok
 * @date 2022-06-23 21:54:48
 */
public class DeleteNodeInABst{
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();
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
     * 迭代法删除二叉搜索树的结点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            // 找到叶子结点了
            return null;
        }
        if (root.val == key) {
            // 找到待删除的结点了

            if (root.left == null && root.right == null) {
                // 当前结点的左右结点都是null，直接删除
                return null;
            }
            if(root.right == null) {
                // 当前结点的左节点不为null
                return root.left;
            }
            if (root.left == null) {
                // 当前结点的右节点不为null
                return root.right;
            }
            if (root.right != null && root.left != null) {
                // 当前结点的左右结点都存在
                // 将左节点放到右节点的最左边
                // 找到右节点的最左边
                TreeNode temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                temp.left = root.left;
                // 返回右边节点
                return root.right;
            }
        } else if (root.val > key) {
            // 当前结点的值比 key 大，需要去左边找
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // 当前结点的值比 key 小，需要去右边找
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}