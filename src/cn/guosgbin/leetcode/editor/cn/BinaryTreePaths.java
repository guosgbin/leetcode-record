package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 *
 * @author Dylan Kwok
 * @date 2022-04-27 23:07:56
 */
public class BinaryTreePaths{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
     * 递归
     *
     * 前序遍历   显性回溯
     *
     * 参数和返回值： 参数 ->  结点，当前路径，结果
     * 递归终止条件： 叶子结点
     * 单层逻辑：添加当前路径，是调用左右结点  前序遍历
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 路径
        List<String> paths = new ArrayList<>();
        traversal(root, paths, result);
        return result;
    }

    /**
     * 遍历
     *
     * @param node 结点
     * @param paths 路径集合
     * @param result 叶子路径集合
     */
    private void traversal(TreeNode node, List<String> paths, List<String> result) {
        // 需要把当前结点添加到路径中
        paths.add(node.val + "");
        // 找到叶子结点了，需要将路径添加到结果集合
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i) + "->");
            }
            sb.append(paths.get(paths.size() - 1));
            result.add(sb.toString());
            return;
        }

        // 不是叶子结点

        if (node.left != null) {
            traversal(node.left, paths, result);
            // 回溯，因为已经从递归中弹出来了，所有需要回溯
            paths.remove(paths.size() - 1);
        }

        if (node.right != null) {
            traversal(node.right, paths, result);
            // 回溯，因为已经从递归中弹出来了，所有需要回溯
            paths.remove(paths.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}