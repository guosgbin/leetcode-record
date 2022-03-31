package cn.guosgbin.leetcode.editor.cn;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/solution/mian-shi-ti-0207-lian-biao-xiang-jiao-sh-b8hn/
 *
 * @author Dylan Kwok
 * @date 2022-03-07 22:33:22
 */
public class IntersectionOfTwoLinkedListsLcci {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedListsLcci().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
//        /**
//         * 既然是找两个链表相交，是指指针相等
//         * <p>
//         * 可以先计算出两个链表的长度，长的链表缩短在短链表的长度，再一一比对
//         * 需要注意的是，只要比较的过程中已经找到两个相等的结点了，那么后面的结点就无需比较了，必定相等。
//         *
//         * @param headA
//         * @param headB
//         * @return
//         */
//        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//            int lengthA = 0;
//            int lengthB = 0;
//            // 计算链表A的长度
//            ListNode cur1 = headA;
//            while (cur1 != null) {
//                lengthA++;
//                cur1 = cur1.next;
//            }
//            // 计算链表B的长度
//            ListNode cur2 = headB;
//            while (cur2 != null) {
//                lengthB++;
//                cur2 = cur2.next;
//            }
//
//            // 获取缩短的值
//            int skip = lengthA - lengthB;
//            ListNode longHead = null;
//            ListNode shortHead = null;
//            if (skip > 0) {
//                ListNode skipNode = headA;
//                // 长链表是A 缩短
//                for (int i = 0; i < skip; i++) {
//                    skipNode = skipNode.next;
//                }
//                longHead = skipNode;
//                shortHead = headB;
//            } else {
//                // 长链表是B 缩短
//                skip = -skip;
//                ListNode skipNode = headB;
//                for (int i = 0; i < skip; i++) {
//                    skipNode = skipNode.next;
//                }
//                longHead = skipNode;
//                shortHead = headA;
//            }
//
//            // 记录相等的指针
//            while (shortHead != null) {
//                if (shortHead == longHead) {
//                   return shortHead;
//                }
//                shortHead = shortHead.next;
//                longHead = longHead.next;
//            }
//            return null;
//        }

        /**
         * 获取相交的结点
         *
         * 思路：
         *                长度a
         *     链表A： O -> O -> O
     *                            \   公共部分长度c
         *                         O -> O -> O
         *                        /
         *     链表B：      O -> O
         *                 长度b
         *
         *     假如相交：
         *          链表A走完自己的长度，在从链表B的头部开始走，此时走过的长度为 (a + c) + b
         *          链表B走完自己的长度，再从链表A的头部开始走，此时走过的长度为 (b + c) + b
         *          此时 结点相交 跳出循环
         *     假如不相交：
         *          链表A走完自己的长度，再走完链表B的长度，走过的长度为 A长度 + B长度，此时指针为null
         *          链表B走完自己的长度，再走完链表A的长度，走过的长度为 B长度 + A长度，此时指针为null
         *          此时 null == null ，跳出循环
         *
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA;
            ListNode curB = headB;
            while (curA != curB) {
                curA = curA != null ? curA.next : headB;
                curB = curB != null ? curB.next : headA;
            }
            // 两种情况
            // 走完 A 和 B 了，此时都是 null
            // 在走对方链表的时候，发生相遇了
            return curA;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}