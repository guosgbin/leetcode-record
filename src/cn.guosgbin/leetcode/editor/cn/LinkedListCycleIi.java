package cn.guosgbin.leetcode.editor.cn;

import java.util.HashSet;
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
     *    O -> O -> O -> O -> O -> O
     *                     /       |
     *                   O <- O <- O
     */
    public ListNode detectCycle(ListNode head) {
        // TODO-KWOK 待解
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}