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
        if (head == null) return head;
        ListNode iter = head;
        ListNode last = head;
        while (iter != null) {
            if (last.val != iter.val) {
                last.next = iter;
                last = last.next;
            }
            iter = iter.next;
        }
        last.next = null;
        return head;
    }
}