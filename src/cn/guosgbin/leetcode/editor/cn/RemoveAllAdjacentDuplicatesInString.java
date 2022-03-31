package cn.guosgbin.leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Dylan Kwok
 * @date 2022-03-25 23:25:42
 */
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 需要最后反转字符串
         */
//        public String removeDuplicates(String s) {
//            char[] sc = s.toCharArray();
//            Stack<Character> stack = new Stack<>();
//
//            for (char c : sc) {
//                if (stack.isEmpty() || stack.peek() != c) {
//                    // 假如栈内没有元素，或者当前遍历到的元素和栈顶元素不相等
//                    stack.push(c);
//                } else {
//                    stack.pop();
//                }
//            }
//            StringBuilder sb = new StringBuilder();
//            while (!stack.isEmpty()) {
//                sb.append(stack.pop());
//            }
//
//            sb.reverse();
//            return sb.toString();
//        }

        /**
         * 无需最后反转字符串，直接倒序遍历字符串即可
         * @param s
         * @return
         */
        public String removeDuplicates(String s) {
            char[] sc = s.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (stack.isEmpty() || stack.peek() != c) {
                    // 假如栈内没有元素，或者当前遍历到的元素和栈顶元素不相等
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}