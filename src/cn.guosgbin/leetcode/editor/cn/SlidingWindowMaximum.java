package cn.guosgbin.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * https://leetcode-cn.com/problems/sliding-window-maximum/solution/dong-hua-yan-shi-dan-diao-dui-lie-239hua-hc5u/
 *
 * @author Dylan Kwok
 * @date 2022-03-28 21:40:42
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] arr = {1, -1};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(arr, 3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 单调递减队列
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            // 窗口个数
            int[] res = new int[nums.length - k + 1];

            // 遍历数组中元素，right表示滑动窗口右边界
            for (int right = 0; right < nums.length; right++) {
                // 移除元素
                // 如果队列不为空且当前遍历到的元素大于等于队尾元素，则将队尾元素移除。
                // 直到，队列为空或当前考察元素小于新的队尾元素
                while (!deque.isEmpty() && nums[right] > nums[deque.peekLast()]) {
                    deque.removeLast();
                }

                // 添加当前元素到单调递减队列
                deque.addLast(right);
                // 计算窗口的左边界
                int left = right - k + 1;
                // 当队首元素的下标小于滑动窗口左侧边界left时
                // 表示队首元素已经不再滑动窗口内，因此将其从队首移除
                if (deque.peekFirst() < left) {
                    deque.removeFirst();
                }

                // 由于数组下标从0开始，因此当窗口右边界right+1大于等于窗口大小k时
                // 意味着窗口形成。此时，队首元素就是该窗口内的最大值
                if (left >= 0) {
                    res[left] = nums[deque.peekFirst()];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}