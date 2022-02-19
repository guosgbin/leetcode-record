package cn.guosgbin.leetcode.editor.cn;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author Dylan Kwok
 * @date 2022-02-18 23:14:43
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            moveElement(nums, 0);
        }

        private void moveElement(int[] nums, int n) {
            int slow = 0;
            int fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != n) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                    slow++;
                }
                fast++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}