package cn.guosgbin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 * https://leetcode-cn.com/problems/repeated-substring-pattern/solution/acm-xuan-shou-tu-jie-leetcode-zhong-fu-d-vl7i/
 *
 * @author Dylan Kwok
 * @date 2022-03-20 16:51:57
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
        System.out.println(solution.repeatedSubstringPattern("abcdabcd0"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 1.暴力
//         * 枚举所有的子串的可能，因为子串至少有两个，所以循环退出条件是 n/2
//         * 父串肯定是子串长度的倍数
//         * 子串肯定是父串的前缀
//         */
//        public boolean repeatedSubstringPattern(String s) {
//            int n = s.length();
//            for (int i = 1; i <= n / 2; i++) {
//                if (n % i == 0) {
//                    boolean match = true;
//                    // 找到某个可能的子串
//                    for (int j = i; j < n; j++) {
//                        // 子串肯定和前一个子串相等
//                        if (s.charAt(j) != s.charAt(j-i)) {
//                            match = false;
//                            break;
//                        }
//                    }
//                    if (match) {
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }

//        /**
//         * 2.字符串复制一份， 移除第一个和最后一个元素
//         */
//        public boolean repeatedSubstringPattern(String s) {
//            String newStr = s + s;
//            return newStr.substring(1, newStr.length() - 1).contains(s);
//        }

        /**
         * 3.kmp
         */
        public boolean repeatedSubstringPattern(String s) {
            // 计算next数组
            char[] sc = s.toCharArray();
            int len = s.length();
            int[] next = new int[len];
            int j = 0;
            for (int i = 1; i < len; i++) {
                while (j>0 && sc[i] != sc[j]) {
                    // 回退
                    j = next[j-1];
                }
                if (sc[i] == sc[j]) {
                    j++;
                }
                next[i] = j;
            }
            System.out.println(Arrays.toString(next));

            int maxLen = next[len - 1];

            if(maxLen == 0 /*|| s.charAt(len - 1) != s.charAt(len - 1 - maxLen)*/){
                return false;
            }

            return len % (len - maxLen) == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}