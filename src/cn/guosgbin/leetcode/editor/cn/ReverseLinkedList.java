package cn.guosgbin.leetcode.editor.cn;

/**
 * @author Dylan Kwok
 * @date 2022-03-03 21:59:52
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(3, null);
        ListNode node4 = new ListNode(4, null);
        ListNode node5 = new ListNode(5, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = solution.reverseList(node1);


    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
//        /**
//         * 迭代法 头插法
//         */
//        public ListNode reverseList(ListNode head) {
//            // 创建一个虚拟结点
//            ListNode sentinelNode = new ListNode(-1, null);
//            // 遍历旧链表，依次插入第一个位置
//            ListNode cur = head;
//            while (cur != null) {
//                // 记录下一个元素位置
//                ListNode next = cur.next;
//                // 插入第一个位置
//                cur.next = sentinelNode.next;
//                sentinelNode.next = cur;
//                cur = next;
//            }
//            return sentinelNode.next;
//        }

//        /**
//         * 递归
//         */
//        public ListNode reverseList(ListNode head) {
//            if (head == null || head.next == null) {
//                return head;
//            }
//            ListNode newHead = reverseList(head.next);
//            head.next.next = head;
//            head.next = null;
//            return newHead;
//        }


        /**
         * 迭代 双指针
         */
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode tempNext = cur.next;

                cur.next = prev;
                prev = cur;
                cur = tempNext;
            }
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}