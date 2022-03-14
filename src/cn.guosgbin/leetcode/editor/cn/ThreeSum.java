package cn.guosgbin.leetcode.editor.cn;

import java.util.*;

/**
 * @author Dylan Kwok
 * @date 2022-03-14 00:13:41
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {1,1,1};
//        int[] nums = {0, 0, 0,0};
        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println(solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 排序+快慢指针
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 排序
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            int k = 0;
            while (k < nums.length - 2) {
                if (nums[k] > 0) {
                    // 因为是正序排序，当k位置的数大于0时，此时 i和j 位置的数肯定是大于0的，那么他们的和肯定大于0
                    return result;
                }
                if (k > 0 && nums[k] == nums[k - 1]) {
                    k++;
                    // 当k>0时，假如此时k位置的元素和前一位的元素值一样，则跳过这个数
                    continue;
                }
                int i = k + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j];
                    if (sum == 0) {
                        // 找到和为0的数了，记录
                        result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        // i指针后移
                        while (i < j && nums[i] == nums[++i]) ;
                        // j指针前移
                        while (i < j && nums[j] == nums[--j]) ;
                    } else if (sum > 0) {
                        // 三数之和大于0，则需要j指针前移
                        // ps.就算j的前一个元素和当前j的元素一样，此时j--，求的和肯定是大于0的，会继续j--
                        j--;
                    } else if (sum < 0) {
                        // 三数之和小于0，则需要i指针后移
                        i++;
                    }
                }
                k++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}