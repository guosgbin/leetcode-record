package cn.guosgbin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Dylan Kwok
 * @date 2022-03-13 19:07:07
 */
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 笨比哈希表
//         */
//        public int[] twoSum(int[] nums, int target) {
//            // 找出每个需要的数,用哈希表存储
//            Map<Integer, Integer> map = new HashMap<>(nums.length);
//            for (int i = 0; i < nums.length; i++) {
//                map.put(nums[i], i);
//            }
//
//            for (int i = 0; i < nums.length; i++) {
//                int num = nums[i];
//                int searchNum = target - num;
//                Integer idx = map.get(searchNum);
//                if (idx != null && idx != i) {
//                    return new int[]{i,idx};
//                }
//            }
//            return new int[0];
//        }

        /**
         * 哈希表优化
         */
        public int[] twoSum(int[] nums, int target) {
            // 找出每个需要的数,用哈希表存储
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int searchNum = target - nums[i];
                Integer idx = map.get(searchNum);
                if (idx != null) {
                    return new int[] {idx, i};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}