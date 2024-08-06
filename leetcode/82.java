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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-101);
        ListNode iter = head;
        ListNode last = newHead;
        while (iter != null) {
            if (iter.next != null && iter.val == iter.next.val) {
                int curVal = iter.val;
                while (iter != null && iter.val == curVal) {
                    iter = iter.next;
                }
            } else {
                last.next = iter;
                last = last.next;
                iter = iter.next;
            }
        }
        last.next = null;
        return newHead.next;
    }
}