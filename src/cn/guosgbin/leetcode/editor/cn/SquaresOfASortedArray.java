package cn.guosgbin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * @author Dylan Kwok
 * @date 2022-02-20 17:05:26
 */
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
//        int[] nums = {-4, -1, 0, 3, 10};
//        int[] nums = {-5, -3, -2, -1};
        int[] nums = {-7,-3,2,3,11};
        int[] newNums = solution.sortedSquares(nums);
        System.out.println(Arrays.toString(newNums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] arr = new int[nums.length];
            int index = nums.length - 1;
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                if (nums[left] * nums[left] > nums[right] * nums[right]) {
                    // 左边大
                    arr[index] = nums[left] * nums[left];
                    left++;
                } else {
                    // 右边大
                    arr[index] = nums[right] * nums[right];
                    right--;
                }
                index--;
            }
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}