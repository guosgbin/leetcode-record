package cn.guosgbin.leetcode.editor.cn;
 /**
 * @author Dylan Kwok
 * @date 2022-03-06 23:01:23
 */
public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
   }

     public class ListNode {
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
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinelNode = new ListNode(-1, head);
        ListNode slow = sentinelNode;
        ListNode fast = sentinelNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 此时slow指针指向 要删除的元素的前一个结点
        // 删除slow指针后的一个元素
        slow.next = slow.next.next;
        return sentinelNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}