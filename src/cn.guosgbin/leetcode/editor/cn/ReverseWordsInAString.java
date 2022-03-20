package cn.guosgbin.leetcode.editor.cn;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dylan Kwok
 * @date 2022-03-16 23:46:43
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
        System.out.println(solution.reverseWords("  hello     world  "));
//        System.out.println(solution.reverseWords("the sky is blue"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 1.使用语言 API
//         */
//        public String reverseWords(String s) {
//            s = s.trim();
//            List<String> list = Arrays.asList(s.split(" +"));
//            Collections.reverse(list);
//            return String.join(" ", list);
//        }

//        /**
//         * 2.反转字符串
//         */
//        public String reverseWords(String s) {
//            // 移除前后空格，和中间的冗余空格
//            StringBuilder sb = trim(s);
//            // 反转字符串
//            reverse(sb, 0, sb.length() - 1);
//            // 反转每个单词
//            reverseEachWord(sb);
//            return sb.toString();
//        }
//
//        private StringBuilder trim(String s) {
//            int left = 0;
//            int right = s.length() - 1;
//            // 删除前面的空格
//            while (s.charAt(left) == ' ') {
//                left++;
//            }
//            // 删除后面的空格
//            while (s.charAt(right) == ' ') {
//                right--;
//            }
//            // 删除中间多余的空格
//            StringBuilder sb = new StringBuilder();
//            while (left <= right) {
//                char c = s.charAt(left);
//                if (c != ' ') {
//                    sb.append(c);
//                } else if (sb.charAt(sb.length() - 1) != ' ') {
//                    // 空格前一个位置不是空格就添加
//                    sb.append(c);
//                }
//                left++;
//            }
//            return sb;
//        }
//
//        public void reverse(StringBuilder sb, int left, int right) {
//            while (left < right) {
//                char tmp = sb.charAt(left);
//                sb.setCharAt(left++, sb.charAt(right));
//                sb.setCharAt(right--, tmp);
//            }
//        }
//
//        public void reverseEachWord(StringBuilder sb) {
//            int n = sb.length();
//            int start = 0;
//            int end = 0;
//            while (start < n) {
//                // 循环至单词的末尾
//                while (end < n && sb.charAt(end) != ' ') {
//                    ++end;
//                }
//                reverse(sb, start, end - 1);
//                // 注意跳过空格
//                start = end + 1;
//                end++;
//            }
//
//        }

        /**
         * 使用双端队列操作
         */
        public String reverseWords(String s) {
            // 移除前后空格
            int left = 0;
            while (s.charAt(left) == ' ') {
                left++;
            }
            int right = s.length() - 1;
            while (s.charAt(right) == ' ') {
                right--;
            }
            Deque<String> deque = new ArrayDeque<>();

            StringBuilder sb = new StringBuilder();
            while (left <= right) {
                char c = s.charAt(left);
                if (c != ' ') {
                    sb.append(c);
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    // 前一个位置不是空格
                    deque.addFirst(sb.toString());
                    sb.setLength(0);
                }
                left++;
            }
            deque.addFirst(sb.toString());
            return String.join(" ", deque);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}