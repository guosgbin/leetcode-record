package cn.guosgbin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/fruit-into-baskets/
 *
 * @author Dylan Kwok
 * @date 2022-02-26 23:33:41
 */
public class FruitIntoBaskets {
    public static void main(String[] args) {
        Solution solution = new FruitIntoBaskets().new Solution();
        int[] fruits = {1, 2, 3, 2, 2};
        System.out.println(solution.totalFruit(fruits));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 刚开始的蠢逼做法，但是做出来了
//         */
//        public int totalFruit(int[] fruits) {
//            // 定义篮子的 Map， key为水果ID， value 为水果数量
//            Map<Integer, Integer> container = new HashMap<>();
//            // 定义左右指针
//            int left = 0;
//            int right = 0;
//            int maxLen = 0;
//            while (right < fruits.length) {
//                // 获取右指针指向的元素
//                int rEle = fruits[right];
//                if (container.size() < 2) {
//                    // 添加到容器中
//                    container.put(rEle, container.getOrDefault(rEle, 0) + 1);
//                    right++;
//                } else if (container.size() == 2 && inContainer(container, rEle)) {
//                    // 当前右指针指向的元素还在容器中,直接增加元素个数
//                    container.put(rEle, container.getOrDefault(rEle, 0) + 1);
//                    right++;
//                }
//
//                while ((container.size() == 2 && !inContainer(container, rEle))
//                        || (right == fruits.length && left < right)) {
//                    // 获取左指针指向的元素
//                    int lEle = fruits[left];
//
//                    // 记录最大元素个数
//                    if (right - left > maxLen) {
//                        maxLen = right - left;
//                    }
//
//                    if (inContainer(container, lEle)) {
//                        // 在容器中，移除元素
//                        Integer count = container.get(lEle);
//                        if (count != null && count > 1) {
//                            container.put(lEle, count - 1);
//                        } else {
//                            container.remove(lEle);
//                        }
//                    }
//                    left++;
//                }
//            }
//            return maxLen;
//        }
//
//        // 判断容器中是否有指定类型的水果
//        private boolean inContainer(Map<Integer, Integer> container, int ele) {
//            for (Integer o : container.keySet()) {
//                if (ele == o) {
//                    return true;
//                }
//            }
//            return false;
//        }


        /**
         * 滑动窗口
         */
        public int totalFruit(int[] fruits) {
            // 摘取的水果个数
            int count = 0;
            int left = 0;
            int right = 0;
            Map<Integer, Integer> container = new HashMap<>();

            while (right < fruits.length) {
                int rEle = fruits[right];
                container.put(rEle, container.getOrDefault(rEle, 0) + 1);
                while (container.size() >= 3) {
                    int lEle = fruits[left];
                    // 查询 left 指针指向的水果的类型的个数
                    Integer singleCount = container.get(lEle);
                    if (singleCount != null && singleCount > 1) {
                        // 该类型的水果的个数 大于 1， 减一个
                        container.put(lEle, container.get(lEle) - 1);
                    } else {
                        // 该类型的水果的个数
                        container.remove(lEle);
                    }
                    left++;
                }

                count = Math.max(count, right - left + 1);

                right++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}