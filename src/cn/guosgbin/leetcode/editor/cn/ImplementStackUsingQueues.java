package cn.guosgbin.leetcode.editor.cn;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Dylan Kwok
 * @date 2022-03-23 21:51:39
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
//        Solution solution = new ImplementStackUsingQueues().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

//    /**
//     * 两个队列
//     */
//    class MyStack {
//        private LinkedBlockingQueue<Integer> queue1 = new LinkedBlockingQueue<>();
//        private LinkedBlockingQueue<Integer> queue2 = new LinkedBlockingQueue<>();
//
//        public MyStack() {
//
//        }
//
//        public void push(int x) {
//            while (!queue1.isEmpty()) {
//                queue2.offer(queue1.poll());
//            }
//            queue1.offer(x);
//            while (!queue2.isEmpty()) {
//                queue1.offer(queue2.poll());
//            }
//        }
//
//        public Integer pop() {
//            return queue1.poll();
//        }
//
//        public Integer top() {
//            return queue1.peek();
//        }
//
//        public boolean empty() {
//            return queue1.isEmpty();
//        }
//    }


    /**
     * 一个队列实现
     */
    class MyStack {
        private LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        public MyStack() {

        }

        public void push(int x) {
            int size = queue.size();
            queue.offer(x);
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
        }

        public Integer pop() {
            return queue.poll();
        }

        public Integer top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}