package cn.guosgbin.leetcode.editor.cn;

/**
 * @author Dylan Kwok
 * @date 2022-02-17 23:31:52
 */
public class RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 双指针
//         */
//        public int removeDuplicates(int[] nums) {
//            if (nums.length <= 2) {
//                return nums.length;
//            }
//            int slow = 2;
//            int fast = 2;
//            while (fast < nums.length) {
//                if (nums[fast] != nums[slow - 2]) {
//                    nums[slow] = nums[fast];
//                    slow++;
//                }
//                fast++;
//            }
//            return slow;
//        }

        /**
         * 删除有序数组中的重复项的通用解法
         * 保留 K 个
         */
        public int removeDuplicates(int[] nums) {
            return removeDuplicatesByCount(nums, 2);
        }

        public int removeDuplicatesByCount(int[] nums, int k) {
            if (nums.length < k) {
                return nums.length;
            }
            int slow = k;
            int fast = k;
            while (fast < nums.length) {
                if (nums[fast] != nums[slow - k]) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}