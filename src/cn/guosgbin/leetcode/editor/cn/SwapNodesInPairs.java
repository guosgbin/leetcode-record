package cn.guosgbin.leetcode.editor.cn;

import java.util.List;

/**
 * @author Dylan Kwok
 * @date 2022-03-04 23:12:31
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);

//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

//        System.out.println(listNode1);
        ListNode listNode = solution.swapPairs(null);
        System.out.println(listNode);

    }

    static class ListNode {
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
            ListNode cur = this;
            StringBuilder builder = new StringBuilder("[");
            while (cur != null) {
                if (cur.next == null) {
                    builder.append(cur.val);
                } else {
                    builder.append(cur.val + ", ");
                }
                cur = cur.next;
            }
            return builder.append("]").toString();
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
        public ListNode swapPairs(ListNode head) {
            ListNode sentinelNode = new ListNode(-1, head);
            // 指针需要指向要交换两个结点的前面一个位置
            ListNode cur = sentinelNode;
            while (cur.next != null) {
                if (cur.next.next != null) {
                    // 说明当前结点的下一个结点存在，需要交换位置
                    ListNode temp = cur.next;
                    cur.next = temp.next;
                    temp.next = cur.next.next;
                    cur.next.next = temp;
                    cur = temp;
                } else {
                    break;
                }
            }
            return sentinelNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}