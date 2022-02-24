package cn.guosgbin.leetcode.editor.cn;

/**
 * @author Dylan Kwok
 * @date 2022-02-23 23:29:08
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * ascii码数组 滑动窗口
         */
        public String minWindow(String s, String t) {
            // 前置校验
            if (s == null || t == null
                    || s.length() == 0 || t.length() == 0
                    || s.length() < t.length()) {
                return "";
            }

            // 表示滑动窗口内字符的数组
            int[] window = new int[128];
            // 组装原始数据数组
            int[] origin = new int[128];
            for (int i = 0; i < t.length(); i++) {
                origin[t.charAt(i)]++;
            }

            // 表示滑动窗口中已经找到的元素个数
            // 在 right 指针前进找到元素时 +1
            // 在 left 指针前进时丢掉的字符是要找的字符时则 -1
            // distance 只会在字符没找完时才会+1
            int distance = 0;
            int left = 0;
            int right = 0;
            int start = 0;
            // 最小长度
            int minLen = Integer.MAX_VALUE;
            // 退出条件是 right 指针已经遍历完数组
            while (right < s.length()) {
                // right 指针前进指向的字符
                char rEle = s.charAt(right);
                // 判断前进时的指针指向的字符是否是要找的字符
                if (origin[rEle] == 0) {
                    // right指针指向不是要找的字符
                    right++;
                    continue;
                }
                // right指针指向的是要找的字符
                // distance 只会在字符没找完时才会+1
                if (origin[rEle] > window[rEle]) {
                    distance++;
                }
                window[rEle]++;
                right++;
                // 退出条件是 distance != t.length()
                // 说明 left 指针前进时丢掉的元素是要找的字符，导致当前滑动窗口中的元素是不满足题目的
                while (distance == t.length()) {
                    // left 指针前进
                    char lEle = s.charAt(left);
                    // 判断最小长度
                    if (right - left < minLen) {
                        minLen = right - left;
                        // 记录开始索引
                        start = left;
                    }
                    if (origin[lEle] == 0) {
                        // left 指针前进时丢掉的字符不是要找的字符，说明窗口中剩下的字符还是满足题意的
                        left++;
                        continue;
                    }
                    // 当 left 指针前进时丢掉的字符时要找的字符
                    if (origin[lEle] == window[lEle]) {
                        distance--;
                    }
                    window[lEle]--;
                    left++;
                }
            }
            return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}