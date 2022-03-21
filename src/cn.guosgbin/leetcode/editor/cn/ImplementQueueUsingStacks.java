package cn.guosgbin.leetcode.editor.cn;

import java.util.Stack;

/**
 * @author Dylan Kwok
 * @date 2022-03-21 22:32:07
 */
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
//        Solution solution = new ImplementQueueUsingStacks().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 先进先出
     * 思路
     *
     * 1.添加元素
     * 依次添加三个元素 1 2 3，添加元素只管往 栈1 里 push
     * |   |   |   |
     * | 3 |   |   |
     * | 2 |   |   |
     * | 1 |   |   |
     *  栈1     栈2
     *
     * 2.移除队首元素
     * 要想移出元素1，需要将栈1依次弹出，然后添加到 栈2中，弹出栈2的元素
     * |   |   |   |     |   |   |   |     |   |   |   |     |   |   |   |
     * | 3 |   |   |     |   |   | 1 |     |   |   |   |     |   |   |   |
     * | 2 |   |   | --> |   |   | 2 | --> |   |   | 2 | --> | 3 |   |   |
     * | 1 |   |   |     |   |   | 3 |     |   |   | 3 |     | 2 |   |   |
     *  栈1     栈2        栈1     栈2        栈1     栈2        栈1     栈2
     *
     * 3.查看队首元素 和移除的操作差不多，差别就是不pop，而是peek
     * 这里使用一个变量 first 来记录
     *
     * 4.查看队列是否为空，就判断栈1是否为空
     *
     */
    class MyQueue {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();
        private Integer first;

        public MyQueue() {

        }

        // 添加元素
        public void push(int x) {
            if (stack1.isEmpty()) {
                // 栈为空，赋值队首元素
                first = x;
            }
            stack1.push(x);
        }

        // 弹出队列开头元素
        public int pop() {
            while (!stack1.isEmpty()) {
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
            Integer result = stack2.pop();
            // 既然弹出了队首元素，那么此时需要记录新的队首元素
            if (!stack2.isEmpty()) {
                first = stack2.peek();
            } else {
                first = null;
            }
            while (!stack2.isEmpty()) {
                Integer pop = stack2.pop();
                stack1.push(pop);
            }
            return result;
        }

        public int peek() {
            return first;
        }

        public boolean empty() {
            return stack1.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}