package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan Kwok
 * @date 2022-02-28 22:19:29
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();

        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(solution.spiralOrder(matrix));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            // 行
            int rows = matrix.length;
            // 列
            int columns = matrix[0].length;
            // 矩阵元素总数
            int target = rows * columns;
            // 上下左右
            int top = 0;
            int right = columns - 1;
            int bottom = rows - 1;
            int left = 0;
            // 输出集合
            List<Integer> result = new ArrayList<>();

            int index = 0;
            while (index < target) {
                // 顶部 左到右
                for (int i = left; i <= right && index < target; i++) {
                    result.add(matrix[left][i]);
                    index++;
                }
                top++;
                // 右边 顶到底
                for (int i = top; i <= bottom && index < target; i++) {
                    result.add(matrix[i][right]);
                    index++;
                }
                right--;
                // 底部 右到左
                for (int i = right; i >= left && index < target; i--) {
                    result.add(matrix[bottom][i]);
                    index++;
                }
                bottom--;
                // 左边 底到顶
                for (int i = bottom; i >= top && index < target; i--) {
                    result.add(matrix[i][left]);
                    index++;
                }
                left++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}