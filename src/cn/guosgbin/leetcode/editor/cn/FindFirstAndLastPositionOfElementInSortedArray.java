package cn.guosgbin.leetcode.editor.cn;

/**
 * @author Dylan Kwok
 * @date 2022-02-13 22:55:00
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 暴力解法
     */
//    public int[] searchRange(int[] nums, int target) {
//        int start = 0;
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                if (count == 0) {
//                    // 第一次遇到该值
//                    start = i;
//                }
//                count++;
//            }
//        }
//        if (count == 0) {
//            return new int[]{-1, -1};
//        } else {
//            return new int[]{start, start + count - 1};
//        }
//    }
    public int[] searchRange(int[] nums, int target) {
        // 查找左边界
        int start = leftBound(nums, target);
        // 查找右边界
        int end = rightBound(nums, target);
        return new int[]{start, end};
    }

    private int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 找到了Target目标值，但是可能不是最左边的，需要左缩继续寻找
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        // 边界校验
        // left = right + 1
        if (left >= nums.length || nums[left] != target) {
            return -1;
        } else {
            return left;
        }
    }

    private int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 找到了Target目标值，但是可能不是最右边的，需要右缩继续寻找
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (right <0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}