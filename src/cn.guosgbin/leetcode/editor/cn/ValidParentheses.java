package cn.guosgbin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author Dylan Kwok
 * @date 2022-03-24 22:40:26
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 思路1：使用字典
//         * 时间复杂度： O(n)
//         * 空间复杂度： O(n + 哈希表元素(key 和 value 有6个))
//         */
//        public boolean isValid(String s) {
//            if (s == null || s.length() % 2 != 0) {
//                // 不是偶数，说明肯定不符合
//                return false;
//            }
//            // 构建字典
//            Map<Character, Character> dic = new HashMap<>();
//            dic.put('(', ')');
//            dic.put('[', ']');
//            dic.put('{', '}');
//
//            LinkedList<Character> stack = new LinkedList<>();
//            // 遍历字符串，
//            // 在字典中的字符就添加其value到栈中
//            // 不在字典中的字符串，就判断栈弹出的元素和当前遍历的字符是否相等
//            for (int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//                if (dic.containsKey(c)) {
//                    // 字典中包含此key，添加value到栈中
//                    stack.push(dic.get(c));
//                } else {
//                    // 不在字典中，判断弹出的元素和当前遍历到的字符是否相等
//                    if (stack.isEmpty()) {
//                        // 栈中没有元素，说明肯定没有另一半括号
//                        return false;
//                    }
//                    if (c != stack.pop()) {
//                        return false;
//                    }
//                }
//            }
//            // 最后，满足条件的元素的栈肯定是空的，因为括号一一对应
//            return stack.isEmpty();
//        }


        /**
         * 思路2:
         * 时间复杂度： O(n)
         * 空间复杂度： O(n)
         */
        public boolean isValid(String s) {
            if (s == null || s.length() % 2 != 0) {
                // 不是偶数，说明肯定不符合
                return false;
            }

            LinkedList<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else if (c == '{') {
                    stack.push('}');
                } else if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}