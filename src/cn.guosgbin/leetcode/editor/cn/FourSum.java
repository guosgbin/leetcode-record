package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dylan Kwok
 * @date 2022-03-15 21:02:05
 */
public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int[] nums = {2, 2, 2, 2, 2};
//        System.out.println(solution.fourSum(nums, 8));
        System.out.println(Integer.MAX_VALUE);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 排序+快慢指针
//         */
//        public List<List<Integer>> fourSum(int[] nums, int target) {
//            Arrays.sort(nums);
//            List<List<Integer>> result = new ArrayList<>();
//            for (int m = 0; m < nums.length - 3; m++) {
//                if (m > 0 && nums[m] == nums[m - 1]) {
//                    // 跳过重复的
//                    continue;
//                }
//                for (int n = m + 1; n < nums.length - 2; n++) {
//                    if (n > m + 1 && nums[n] == nums[n - 1]) {
//                        // 跳过重复的
//                        continue;
//                    }
//                    // 后面的第一位
//                    int i = n + 1;
//                    // 后面的最后一位
//                    int j = nums.length - 1;
//                    while (i < j) {
//                        int sum = nums[m] + nums[n] + nums[i] + nums[j];
//                        if (sum == target) {
//                            // 找到元素了
//                            result.add(Arrays.asList(nums[m], nums[n], nums[i], nums[j]));
//                            // i 指针后移
//                            while (i < j && nums[i] == nums[++i]) ;
//                            // j 指针前移
//                            while (i < j && nums[j] == nums[--j]) ;
//                        } else if (sum > target) {
//                            // 四数之和大于目标值，需要 j指针前移
//                            j--;
//                        } else if (sum < target) {
//                            // 四数之和小于目标值，需要 i指针前移
//                            i++;
//                        }
//                    }
//                }
//            }
//            return result;
//        }


        /**
         * 排序+快慢指针  剪枝操作
         */
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            int length = nums.length;
            List<List<Integer>> result = new ArrayList<>();
            for (int m = 0; m < nums.length - 3; m++) {
                if (m > 0 && nums[m] == nums[m - 1]) {
                    // 跳过重复的
                    continue;
                }
                if ((long) nums[m] + nums[m + 1] + nums[m + 2] + nums[m + 3] > target) {
                    // 在确定第一个数之后，说明此时剩下的三个数无论取什么值，四数之和一定大于target，因此退出第一重循环；
                    break;
                }
                if ((long) nums[m] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                    // 在确定第一个数之后，说明此时剩下的三个数无论取什么值，四数之和一定小于target，因此跳过第一重循环直接进入下一轮，
                    continue;
                }
                for (int n = m + 1; n < nums.length - 2; n++) {
                    if (n > m + 1 && nums[n] == nums[n - 1]) {
                        // 跳过重复的
                        continue;
                    }
                    if ((long) nums[m] + nums[n] + nums[n + 1] + nums[n + 2] > target) {
                        // 在确定前两个数之后，说明此时剩下的两个数无论取什么值，四数之和一定大于target，因此退出第二重循环；
                        break;
                    }
                    if ((long) nums[m] + nums[n] + nums[length - 1] + nums[length - 2] < target) {
                        // 在确定前两个数之后，说明此时剩下的两个数无论取什么值，四数之和一定小于target，因此第二重循环直接进入下一轮，
                        continue;
                    }
                    // 后面的第一位
                    int i = n + 1;
                    // 后面的最后一位
                    int j = nums.length - 1;
                    while (i < j) {
                        int sum = nums[m] + nums[n] + nums[i] + nums[j];
                        if (sum == target) {
                            // 找到元素了
                            result.add(Arrays.asList(nums[m], nums[n], nums[i], nums[j]));
                            // i 指针后移
                            while (i < j && nums[i] == nums[++i]) ;
                            // j 指针前移
                            while (i < j && nums[j] == nums[--j]) ;
                        } else if (sum > target) {
                            // 四数之和大于目标值，需要 j指针前移
                            j--;
                        } else if (sum < target) {
                            // 四数之和小于目标值，需要 i指针前移
                            i++;
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}