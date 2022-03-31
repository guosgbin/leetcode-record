package cn.guosgbin.leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author Dylan Kwok
 * @date 2022-03-08 23:17:48
 */
public class LinkedListCycleIi{
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
   }

     class ListNode {
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
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
//    /**
//     * 哈希表
//     */
//    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        ListNode cur = head;
//        while (cur != null) {
//            if (set.contains(cur)) {
//                return cur;
//            } else {
//                set.add(cur);
//            }
//            cur = cur.next;
//        }
//        return null;
//    }


    /**
     * 双指针
     *
     * 链表头到交点前一个位置的结点个数 a
     * 环内结点个数 b
     *
     * 假如指针 A 以1个结点的速度前进，指针B以2个结点的速度前进
     *
     * 假如
     *    |------ a -----|
     *    O -> O -> O -> O -> O -> O
     *                     /       |
     *                   O <- O <- O
     *
     *    假如 快慢指针 在环内的某个结点相遇，
     *    环入口到相遇点长度 b
     *    相遇点到环入口长度 c
     *
     *    在环内相遇，那么快指针肯定比慢指针多走了 n 圈
     *
     *    假如快指针和慢指针走过的长度分别为 f，s
     *    f = a + n(b + c) + b
     *    s = a + b  (慢指针入环第一圈没走完的时候就会和快指针相遇)
     *    因为 f = 2s， 即 a + n(b + c) + b = 2(a + b)
     *                 得到 a = (n - 1)(b + c) + c
     *
     * 从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离。
     * 此时定义一个新指针，速度为1，此时慢指针继续前进，这两个指针相遇的地方就是环的入口
     */
    public ListNode detectCycle(ListNode head) {
        // 定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        ListNode cur = head;
        while (true) {
            if (fast == null || fast.next == null) {
                // 链表结束了,没有环
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 快慢指针相遇了
               break;
            }
        }

        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}