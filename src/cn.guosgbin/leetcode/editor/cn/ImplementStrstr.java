package cn.guosgbin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Dylan Kwok
 * @date 2022-03-20 14:49:32
 */
public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        System.out.println(solution.strStr("aaa", "aaaa"));

        int[] arr = solution.getNext("aabaaf");
        System.out.println(Arrays.toString(arr));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1.API
         */
//        public int strStr(String haystack, String needle) {
//            return haystack.indexOf(needle);
//        }

//        /**
//         * 2.暴力匹配
//         */
//        public int strStr(String haystack, String needle) {
//            int mLen = haystack.length();
//            int nLen = needle.length();
//
//            // mLen - nLen 判断 是因为 needle 字符串的长度需要 <= haystack剩下的长度
//            for (int i = 0; i <= mLen - nLen; i++) {
//                boolean flag = true;
//                for (int j = 0; j < nLen; j++) {
//                    if (haystack.charAt(i + j) != needle.charAt(j)) {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag) {
//                    return i;
//                }
//            }
//            return -1;
//        }

        /**
         * 3.KMP
         */
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            // 获取next数组
            int[] next = getNext(needle);
            int j = 0;
            // 遍历字符串进行匹配
            for (int i = 0; i < haystack.length(); i++) {
                while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                    // 发现不相等了，j回退继续匹配
                    j = next[j - 1];
                }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                if (j == needle.length()) {
                    return i - needle.length() + 1;
                }
            }
            return -1;
        }

        /**
         * 求next数组
         *
         * @param str
         * @return
         */
        private int[] getNext(String str) {
            int[] next = new int[str.length()];
            char[] sc = str.toCharArray();
            // 表示相等前后缀的个数
            int j = 0;
            // 指针
            int i = 1;
            // 初始化next数组，第一个位置是0
            next[0] = 0;
            for (; i < str.length(); i++) {
                while (j > 0 && sc[j] != sc[i]) {
                    // 回退
                    j = next[j - 1];
                }
                if (sc[j] == sc[i]) {
                    // 匹配到了
                    j++;
                }
                next[i] = j;
            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}