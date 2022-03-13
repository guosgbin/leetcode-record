package cn.guosgbin.leetcode.editor.cn;

import java.util.HashSet;

/**
 * @author Dylan Kwok
 * @date 2022-03-13 17:55:51
 */
public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        System.out.println(solution.isHappy(1111111));


//        System.out.println(solution.getNext(11112));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 解法1 哈希表
//         */
//        public boolean isHappy(int n) {
//            HashSet<Integer> set = new HashSet<>();
//            int next = n;
//            while (true) {
//                next = getNext(next);
//                if (set.contains(next)) {
//                    return false;
//                }
//                if (next == 1) {
//                    return true;
//                }
//                set.add(next);
//
//            }
//        }

        /**
         * 计算一个数
         */
        public int getNext(int n) {
            int sum = 0;
            int num = n;
            while (num > 0) {
                int s = num % 10;
                num = num / 10;
                sum += s * s;
            }
            return sum;
        }

        /**
         * 解法2 快慢指针
         */
        public boolean isHappy(int n) {
            int next = n;
            int nextNext = n;
            while (true) {
                next = getNext(next);
                nextNext = getNext(getNext(nextNext));
                if (next != 1 && next == nextNext) {
                    // 链表有环
                    return false;
                }
                if (next == 1 || nextNext == 1) {
                    return true;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}