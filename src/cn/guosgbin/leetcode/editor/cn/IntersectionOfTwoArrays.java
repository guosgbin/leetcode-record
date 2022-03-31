package cn.guosgbin.leetcode.editor.cn;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * @author Dylan Kwok
 * @date 2022-03-11 23:00:27
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 哈希表
//         */
//        public int[] intersection(int[] nums1, int[] nums2) {
//            Set<Integer> set = new HashSet<>();
//            for (int i : nums1) {
//                set.add(i);
//            }
//
//            Set<Integer> set2 = new HashSet<>();
//            for (int i : nums2) {
//                if (set.contains(i)) {
//                    set2.add(i);
//                }
//            }
//            return set2.stream().mapToInt(o -> o).toArray();
//        }

        /**
         * 数组排序+双指针
         *
         * [2,2,5,7,10]
         * 指针1
         *
         * [1,2,4,5,11]
         * 指针2
         */
        public int[] intersection(int[] nums1, int[] nums2) {
            // 排序
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            // 定义前进指针
            int idx1 = 0;
            int idx2 = 0;
            // 定义前一个的加入结果的指针
            int preNum = 0;

            // 开始遍历
            int[] result = new int[nums1.length + nums2.length];
            while (idx1 < nums1.length && idx2 < nums2.length) {
                int num1 = nums1[idx1];
                int num2 = nums2[idx2];
                if (num1 == num2) {
                   if (preNum == 0 || result[preNum - 1] != num1) {
                       // 两个相等 且是第一次添加到数组
                       result[preNum] = num1;
                       preNum++;
                   }
                   idx1++;
                   idx2++;
                } else if (num1 > num2) {
                    // num1 比 num2 大，说明需要指针2前进
                    idx2++;
                } else if (num1 < num2) {
                    // num1 比 num2 小，说明需要指针1前进
                    idx1++;
                }
            }
            return Arrays.copyOf(result, preNum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}