package cn.guosgbin.leetcode.editor.cn;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
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
//        /**
//         * 单调递减队列
//         *
//         * @param nums
//         * @param k
//         * @return
//         */
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            ArrayDeque<Integer> deque = new ArrayDeque<>();
//            // 窗口个数
//            int[] res = new int[nums.length - k + 1];
//
//            // 遍历数组中元素，right表示滑动窗口右边界
//            for (int right = 0; right < nums.length; right++) {
//                // 移除元素
//                // 如果队列不为空且当前遍历到的元素大于等于队尾元素，则将队尾元素移除。
//                // 直到，队列为空或当前考察元素小于新的队尾元素
//                while (!deque.isEmpty() && nums[right] > nums[deque.peekLast()]) {
//                    deque.removeLast();
//                }
//
//                // 添加当前元素到单调递减队列
//                deque.addLast(right);
//                // 计算窗口的左边界
//                int left = right - k + 1;
//                // 当队首元素的下标小于滑动窗口左侧边界left时
//                // 表示队首元素已经不再滑动窗口内，因此将其从队首移除
//                if (deque.peekFirst() < left) {
//                    deque.removeFirst();
//                }
//
//                // 由于数组下标从0开始，因此当窗口右边界right+1大于等于窗口大小k时
//                // 意味着窗口形成。此时，队首元素就是该窗口内的最大值
//                if (left >= 0) {
//                    res[left] = nums[deque.peekFirst()];
//                }
//            }
//            return res;
//        }

//        /**
//         * 思路1 ：单调递减队列
//         * <p>
//         * 条件：需要满足单调递减队列，队列中的元素需要在滑动窗口的内
//         * <p>
//         * 队列中存储的元素是 数组的索引
//         *
//         * @param nums
//         * @param k
//         * @return
//         */
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            ArrayDeque<Integer> queue = new ArrayDeque<>();
//            int[] res = new int[nums.length - k + 1];
//            for (int right = 0; right < nums.length; right++) {
//                // 移除元素的时机
//                // 队列不为空，且队首的元素小于当前遍历到的元素
//                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[right]) {
//                    queue.removeLast();
//                }
//
//                // 添加元素
//                queue.addLast(right);
//                // 计算此时滑动窗口的左边界,
//                // 可能为负数，说明此时right指针还未走到窗口最大的地方
//                int left = right - k + 1;
//
//                // 假如对列中最大的元素不在滑动窗口中了，则删除这个元素
//                if (left > queue.peekFirst()) {
//                    queue.removeFirst();
//                }
//
//                if (left >= 0) {
//                    res[left] = nums[queue.peekFirst()];
//                }
//            }
//            return res;
//        }


        /**
         * 思路2 优先队列
         * <p>
         * 维护一个最大堆优先队列，首先将前k个元素添加到优先队列
         * 优先队列存的元素是 int数组
         *          0位置是 元素值
         *          1位置是 索引
         *
         * 向后遍历的时候，判断堆顶的元素是否是滑动窗口移出去的元素，假如是移出去的元素，则将堆顶元素移除，直到找到在滑动窗口内的元素
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(arr -> -arr[0]));
            int[] res = new int[nums.length - k + 1];
            for (int right = 0; right < nums.length; right++) {
                int left = right - k + 1;
                queue.add(new int[]{nums[right], right});
                if (!queue.isEmpty()) {
                    while (queue.peek()[1] < left) {
                        queue.remove();
                    }
                }
                if (left >= 0) {
                    res[left] = queue.peek()[0];
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}