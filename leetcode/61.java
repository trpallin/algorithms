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
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode iter = head;
        ListNode last = head;
        while (iter != null) {
            length++;
            last = iter;
            iter = iter.next;
        }
        if (length == 0) {
            return head;
        }
        k %= length;
        if (k == 0) return head;
        last.next = head;
        int count = 0;
        iter = head;
        while (++count < length - k) {
            iter = iter.next;
        }
        head = iter.next;
        iter.next = null;
        return head;
    }
}