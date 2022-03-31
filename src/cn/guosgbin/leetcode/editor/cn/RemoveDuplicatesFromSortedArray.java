package cn.guosgbin.leetcode.editor.cn;
 /**
  * 26. 删除有序数组中的重复项
  * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
  *
 * @author Dylan Kwok
 * @date 2022-02-16 22:51:43
 */
public class RemoveDuplicatesFromSortedArray{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
   }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    /**
//     * 快慢指针
//     */
//    public int removeDuplicates(int[] nums) {
//        int slow = 0;
//        int fast = 1;
//        for (; fast < nums.length; fast++) {
//            if (nums[fast] != nums[slow]) {
//                slow++;
//                nums[slow] = nums[fast];
//            }
//        }
//        return slow + 1;
//    }

//    /**
//     * 快慢指针
//     */
//    public int removeDuplicates(int[] nums) {
//        int slow = 0;
//        int fast = 1;
//        while (fast < nums.length) {
//            if (nums[slow] != nums[fast]) {
//                // slow指针和fast指针的元素值不相等，则将fast位置的元素赋值到slow+1位置
//                slow++;
//                nums[slow] = nums[fast];
//            }
//            fast++;
//        }
//        return slow + 1;
//    }

    /**
     * 快慢指针-小优化
     * 当全部元素都不重复时，可能会有多余的替换操作， 在替换之前判断下 fast - slow 和 1的大小
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                // slow指针和fast指针的元素值不相等，则将fast位置的元素赋值到slow+1位置
                if (fast - slow > 1) {
                    nums[slow + 1] = nums[fast];
                }
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}