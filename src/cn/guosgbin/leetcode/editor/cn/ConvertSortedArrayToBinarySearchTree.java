package cn.guosgbin.leetcode.editor.cn;
 /**
 * @author Dylan Kwok
 * @date 2022-06-29 22:06:49
 */
public class ConvertSortedArrayToBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
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
     * 将有序数组转换成二叉搜索树
     *
     * 递归法
     * 方法的返回值和入参：入参是索引边界，返回值？
     * 递归出口：出口是数组没数据了
     * 单层逻辑：
     *      获取中间的数组，赋值
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    private TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = traversal(nums, left, mid - 1);
        node.right = traversal(nums, mid + 1, right);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}