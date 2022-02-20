package cn.guosgbin.leetcode.editor.cn;

import java.util.Objects;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/
 *
 * @author Dylan Kwok
 * @date 2022-02-19 23:53:42
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
//        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));
//        System.out.println(solution.backspaceCompare("a##c", "#a#c"));
        System.out.println(solution.backspaceCompare("xywrrmp", "xywrrmu#p"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

//        /**
//         * 双指针
//         * 反向遍历两个字符串
//         */
//        public boolean backspaceCompare(String S, String T) {
//            // 定义遍历两个字符串的指针,反向遍历
//            int i = S.length() - 1;
//            int j = T.length() - 1;
//            // 找到下一个有效字符要跳过的字符个数
//            int skipS = 0;
//            int skipT = 0;
//
//            while (i >= 0 || j >= 0) {
//                while (i >= 0) {
//                    if (S.charAt(i) == '#') {
//                        // 遇到 # ,需要将 跳过字符的计算器+1
//                        skipS++;
//                        i--;
//                    } else if (skipS > 0) {
//                        // 此时遇到的字符不是 #，但是由于 需要跳过的字符 > 0,
//                        // 说明当前字符也是无效数据
//                        // 需要将 计算器-1，i-1跳过该字符
//                        skipS--;
//                        i--;
//                    } else {
//                        // 找到有效字符了
//                        break;
//                    }
//                }
//
//                while (j >= 0) {
//                    if (T.charAt(j) == '#') {
//                        // 遇到 # ,需要将 跳过字符的计算器+1
//                        skipT++;
//                        j--;
//                    } else if (skipT > 0) {
//                        // 此时遇到的字符不是 #，但是由于 需要跳过的字符 > 0,
//                        // 说明当前字符也是无效数据
//                        // 需要将 计算器-1，i-1跳过该字符
//                        skipT--;
//                        j--;
//                    } else {
//                        // 找到有效字符了
//                        break;
//                    }
//                }
//
//                // 此时找到了两个字符串的有效字符
//                if (i >= 0 && j >= 0) {
//                    // 说明两个字符串还有剩余字符
//                    if (S.charAt(i) != T.charAt(j)) {
//                        return false;
//                    }
//                } else {
//                    // 前置条件
//                    if (i >= 0 || j >= 0) {
//                        // 说明有一个字符串的有效字符已经查找完了
//                        // 而有一个字符串还有未查找完额度有效数据
//                        return false;
//                    }
//                }
//
//                i--;
//                j--;
//            }
//            return true;
//        }

        /**
         * 快慢指针
         */
        public boolean backspaceCompare(String S, String T) {
            String s = rebuild(S);
            String t = rebuild(T);
            return Objects.equals(s, t);
        }

        public String rebuild(String str) {
            int slow = 0;
            int fast = 0;
            char[] chars = str.toCharArray();
            for (; fast < chars.length; fast++) {
                if (chars[fast] != '#') {
                    chars[slow] = chars[fast];
                    slow++;
                } else if (slow > 0) {
                    slow--;
                }
            }
            // 此时chars数组中的有效位为slow
            return new String(chars, 0, slow);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}