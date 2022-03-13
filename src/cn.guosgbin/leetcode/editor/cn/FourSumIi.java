package cn.guosgbin.leetcode.editor.cn;

import java.util.HashMap;

/**
 * @author Dylan Kwok
 * @date 2022-03-13 23:23:11
 */
public class FourSumIi {
    public static void main(String[] args) {
        Solution solution = new FourSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 哈希表
         */
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            // 数组1和2  数组3和4
            // 各种情况的和记录在 哈希的key中，出现的次数记录在 哈希的value中
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            // 记录数组1和2的情况
            for (int a : nums1) {
                for (int b : nums2) {
                    map.put(a + b, map.getOrDefault(a + b, 0) + 1);
                }
            }
            for (int c : nums3) {
                for (int d : nums4) {
                    // 计算需要组成0的值
                    int needZero = -c - d;
                    Integer singleCount = map.get(needZero);
                    if (singleCount != null) {
                        count += singleCount;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}