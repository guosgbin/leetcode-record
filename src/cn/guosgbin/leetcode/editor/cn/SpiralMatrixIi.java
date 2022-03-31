package cn.guosgbin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 *
 * @author Dylan Kwok
 * @date 2022-02-27 17:31:21
 */
public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        int[][] arr = solution.generateMatrix(5);
        for (int[] nums : arr) {
            System.out.println(Arrays.toString(nums));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] generateMatrix(int n) {
            int top = 0;
            int right = n - 1;
            int bottom = n - 1;
            int left = 0;
            int[][] arr = new int[n][n];
            // 位置要填入的数据
            int num = 1;
            // 目标值
            int target = n * n;
            while (num <= target) {
                // 顶部 左边到右边
                for (int i = left; i <= right; i++) {
                    arr[top][i] = num++;
                }
                top++;

                // 右边 顶部到底部
                for (int i = top; i <= bottom; i++) {
                    arr[i][right] = num++;
                }
                right--;

                // 底部 右边到左边
                for (int i = right; i >= left; i--) {
                    arr[bottom][i] = num++;
                }
                bottom--;

                // 左边 底部到顶部
                for (int i = bottom; i >= top ; i--) {
                    arr[i][left] = num++;
                }
                left++;
            }

            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}