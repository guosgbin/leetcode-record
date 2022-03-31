package cn.guosgbin.leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * https://leetcode-cn.com/problems/top-k-frequent-elements/solution/leetcode-di-347-hao-wen-ti-qian-k-ge-gao-pin-yuan-/
 *
 * @author Dylan Kwok
 * @date 2022-03-29 21:44:04
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 使用小堆
         * 在堆中留下k个元素，就是所求的结果
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> dic = new HashMap<>();
            // 添加数据到map
            for (int num : nums) {
                dic.put(num, dic.getOrDefault(num, 0) +1);
            }
            // 添加数据到优先队列
            PriorityQueue<Map.Entry<Integer, Integer>> queue =
                    new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
            for (Map.Entry<Integer, Integer> entry : dic.entrySet()) {
                if (queue.size() < k) {
                    queue.add(entry);
                } else {
                    // 判断新加的元素和堆顶元素的大小
                    // 因为是最小堆，所以堆顶是最小的元素
                    // 假如当前遍历到的元素比堆顶元素大，就删除堆顶元素
                    if (entry.getValue() > queue.peek().getValue()) {
                        queue.remove();
                        queue.add(entry);
                    }
                }
            }

            return queue.stream()
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}