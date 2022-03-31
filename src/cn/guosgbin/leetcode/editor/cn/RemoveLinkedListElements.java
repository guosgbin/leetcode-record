package cn.guosgbin.leetcode.editor.cn;

/**
 * @author Dylan Kwok
 * @date 2022-03-01 21:54:46
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
//        输入：head = [1,2,6,3,4,5,6], val = 6
        ListNode head = new ListNode(6);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);

        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        ListNode newHead = solution.removeElements(head, 6);

        ListNode cur = newHead;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }


    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "";
        }
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
//         * 迭代
//         */
//        public ListNode removeElements(ListNode head, int val) {
//            ListNode cur = new ListNode(0, head);
//            ListNode newHead = cur;
//            while (cur.next != null) {
//                if (cur.next.val == val) {
//                    // 找到指定元素了，删除这个元素
//                    cur.next = cur.next.next;
//                } else {
//                    cur = cur.next;
//                }
//            }
//            return newHead.next;
//        }

//        /**
//         * 递归
//         */
//        public ListNode removeElements(ListNode head, int val) {
//          if (head == null) {
//              return head;
//          }
//            head.next = removeElements(head.next, val);
//            return head.val == val ? head.next : head;
//        }

        /**
         * 迭代-双指针
         */
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return head;
            }
            ListNode pre = head;
            ListNode cur = head.next;
            while (cur != null) {
                if (cur.val == val) {
                    pre.next = cur.next;
                } else {
                    pre = pre.next;
                }
                cur = cur.next;
            }

            return head.val != val ? head : head.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}