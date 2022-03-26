package cn.guosgbin.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Dylan Kwok
 * @date 2022-03-26 21:35:20
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();
        String[] arr = {"4", "13", "5", "/", "+"};
        System.out.println(solution.evalRPN(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        /**
//         * 栈
//         * <p>
//         * 时间复杂度：O(n) 因为需要遍历一次数组
//         * 空间复杂度：O(n) 使用栈来存储元素
//         */
//        public int evalRPN(String[] tokens) {
//            Stack<Integer> stack = new Stack<>();
//            for (String token : tokens) {
//                if (stack.isEmpty() ||
//                        (!"+".equals(token) && !"-".equals(token) && !"*".equals(token) && !"/".equals(token))) {
//                    // 不是加减乘除
//                    stack.push(Integer.parseInt(token));
//                } else {
//                    // 是加减乘除
//                    int m = stack.pop();
//                    int n = stack.pop();
//                    int result = 0;
//                    switch (token) {
//                        case "+": {
//                            result = n + m;
//                            break;
//                        }
//                        case "-": {
//                            result = n - m;
//                            break;
//                        }
//                        case "*": {
//                            result = n * m;
//                            break;
//                        }
//                        case "/": {
//                            result = n / m;
//                            break;
//                        }
//                    }
//                    stack.push(result);
//                }
//            }
//            return stack.pop();
//        }

        /**
         * 数组模拟栈
         * <p>
         * 对于一个有效的逆波兰表达式，其长度 n 一定是奇数，且操作数的个数一定比运算符的个数多 1 个，
         * 即包含 (n+1)/2 个操作数和 (n-1)/2个运算符。
         * <p>
         * 时间复杂度：O(n) 因为需要遍历一次数组
         * 空间复杂度：O(n) 使用数组来存储元素
         */
        public int evalRPN(String[] tokens) {
            int length = tokens.length;
            int[] stack = new int[(length + 1) / 2];
            int index = -1;
            for (String token : tokens) {
                switch (token) {
                    case "+":
                        index--;
                        stack[index] += stack[index + 1];
                        break;
                    case "-":
                        index--;
                        stack[index] -= stack[index + 1];
                        break;
                    case "*":
                        index--;
                        stack[index] *= stack[index + 1];
                        break;
                    case "/":
                        index--;
                        stack[index] /= stack[index + 1];
                        break;
                    default:
                        stack[++index] = Integer.parseInt(token);
                        break;
                }
            }
            return stack[0];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}