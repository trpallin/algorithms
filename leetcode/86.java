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
    public ListNode partition(ListNode head, int x) {
        ListNode lesser = new ListNode();
        ListNode i1 = lesser;
        ListNode equalOrGreater = new ListNode();
        ListNode i2 = equalOrGreater;
        ListNode iter = head;
        while (iter != null) {
            if (iter.val < x) {
                i1.next = iter;
                i1 = i1.next;
            } else {
                i2.next = iter;
                i2 = i2.next;
            }
            iter = iter.next;
        }
        i2.next = null;
        i1.next = equalOrGreater.next;
        return lesser.next;
    }
}