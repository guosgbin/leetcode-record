package cn.guosgbin.leetcode.editor.cn;
 /**
 * @author Dylan Kwok
 * @date 2022-02-13 19:22:11
 */
public class BinarySearch{
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
//        int[] nums = {-1,0,3,5,9,12};
        //            0 1 2 3 4
//        System.out.println(solution.search(nums, 2));

        int[] nums = {1,3,3,4,5};
        System.out.println(leftBound2(nums, 2));
    }
   
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                // 找到了，返回索引
//                return mid;
//            } else if (nums[mid] > target) {
//                right = mid - 1;
//            } else if (nums[mid] < target) {
//                left = mid + 1;
//            }
//        }
//        return -1;

        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 找到了，返回索引
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

     /**
      * 查找左边界的折半查找 - 左闭右开
      */
     public static int leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        // 退出条件 left == right
        while (left < right) {
            int mid = (left + right) / 2 + left;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                // 左闭
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 右开
                right = mid;
            }
        }
        return left;
     }


     public static int leftBound2(int[] nums,int target) {
         int left = 0;
         int right = nums.length - 1;
         // 退出循环条件是 left = right + 1;
         while (left <= right) {
             int mid = left + (right - left) / 2;
             if (nums[mid] == target) {
                 right = mid - 1;
             } else if (nums[mid] > target) {
                 right = mid - 1;
             } else if (nums[mid] < target) {
                 left = mid + 1;
             }
         }

         if (left >= nums.length || nums[left] != target) {
             return -1;
         }
         return left;
     }
}