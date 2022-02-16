package cn.guosgbin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Dylan Kwok
 * @date 2022-02-16 00:12:49
 */
public class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
//        int[] nums = {3,2,2,3};
//        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
//        int[] nums = {4, 5};
        int[] nums = {2, 2, 2};
        int val = 2;
        System.out.println(solution.removeElement(nums, val));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 最开始的笨比解法
         */
//        public int removeElement(int[] nums, int val) {
//            int count = 0;
//            int length = nums.length;
//            for (int i = 0; i < length - count; i++) {
//                if (nums[i] == val) {
//                    while (true) {
//                        if (length - 1 - count == -1) {
//                            // 减到-1还是和val相等，说明数组中所有元素都是一样的
//                            return 0;
//                        }
//                        if (nums[length - 1 - count] != val) {
//                            break;
//                        }
//                        count++;
//                    }
//                    // 假如后面要替换的索引大于i才替换
//                    if (i < length - 1 - count) {
//                        int temp = nums[i];
//                        nums[i] = nums[length - 1 - count];
//                        nums[length - 1 - count] = temp;
//                        count++;
//                    }
//                }
//            }
//            System.out.println(Arrays.toString(nums));
//            return length - count;
//        }

//        /**
//         * 快慢指针
//         */
//        public int removeElement(int[] nums, int val) {
//            // 定义快慢指针
//            int fast = 0;
//            int slow = 0;
//            // 筷子在
//            for (; fast < nums.length; fast++) {
//                if (nums[fast] != val) {
//                    nums[slow] = nums[fast];
//                    slow++;
//                }
//            }
//            return slow;
//        }

//        /**
//         * 快慢指针-2
//         */
//        public int removeElement(int[] nums, int val) {
//            // 定义慢指针，快指针在增强for循环里面隐含了
//            int slow = 0;
//            for (int num : nums) {
//                if (num != val) {
//                    nums[slow] = num;
//                    slow++;
//                }
//            }
//            return slow;
//        }

//        /**
//         * 双指针-优化版
//         */
//        public int removeElement(int[] nums, int val) {
//            int left = 0;
//            int right = nums.length - 1;
//            while (left <= right) {
//                if (nums[left] == val) {
//                    // left 指针的元素等于 val ，需要和 right 指针替换
//                    // 替换前需要判断 right 指针是否等于 val
//                    while (nums[right] == val) {
//                        right--;
//                        if (right < 0) {
//                            // 防止数组越界，此处说明数组的数据全部是 val
//                            return 0;
//                        }
//                    }
//                    // 用 right 位置的值替换 left
//                    nums[left] = nums[right];
//                    right--;
//                } else {
//                    left++;
//                }
//            }
//            System.out.println(Arrays.toString(nums));
//            return left;
//        }

        /**
         * 双指针-优化简化版
         */
        public int removeElement(int[] nums, int val) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                if (nums[left] == val) {
                    // 用 right 位置的值替换 left
                    nums[left] = nums[right];
                    right--;
                } else {
                    left++;
                }
            }
            System.out.println(Arrays.toString(nums));
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}