package cn.guosgbin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @author Dylan Kwok
 * @date 2022-02-22 22:43:25
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        int[] nums = {2, 3, 1, 2, 4, 3};
//        int[] nums = {2, 5, 7, 10, 15, 18, 20};
        System.out.println(solution.minSubArrayLen(7, nums));
//        System.out.println(Arrays.binarySearch(nums, 9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 暴力
//         */
//        public int minSubArrayLen(int target, int[] nums) {
//            int len = Integer.MAX_VALUE;
//            for (int i = 0; i < nums.length; i++) {
//                int sum = 0;
//                for (int j = i; j < nums.length; j++) {
//                    sum += nums[j];
//                    if (sum >= target) {
//                        // 计算当前的长度
//                        int tempLen = j - i + 1;
//                        if (tempLen < len) {
//                            len = tempLen;
//                        }
//                        break;
//                    }
//                }
//            }
//            return len == Integer.MAX_VALUE ? 0 : len;
//        }

//        /**
//         * 滑动窗口
//         */
//        public int minSubArrayLen(int target, int[] nums) {
//            int start = 0;
//            int end = 0;
//            int len = Integer.MAX_VALUE;
//            int sum = 0;
//            while (end < nums.length) {
//                sum += nums[end];
//                while (sum >= target) {
//                    // 找到了大于 target 的值了
//                    int tempLen = end - start + 1;
//                    len = Math.min(len, tempLen);
//                    // start 前进
//                    sum -= nums[start];
//                    start++;
//                }
//                end++;
//            }
//
//            return len == Integer.MAX_VALUE ? 0 : len;
//        }


        /**
         * 前缀和 + 二分法
         */
        public int minSubArrayLen(int s, int[] nums) {
            int n = nums.length;
            int minLen = Integer.MAX_VALUE;
            // 组装前缀和
            int[] sums = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
            // 二分查找
            for (int i = 1; i < sums.length + 1; i++) {
                int target = s + sums[i - 1];
                int end = Arrays.binarySearch(sums, target);
                if (end < 0) {
                    // 说明没找到相等的元素
                    end = - end - 1;
                }
                if (end <= n) {
                    // 说明还存在大于 s 的数
                    minLen = Math.min(minLen, end - (i - 1));
                }
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}