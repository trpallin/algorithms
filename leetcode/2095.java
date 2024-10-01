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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null) return null;
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length == 1) {
            return null;
        }
        int idxToDelete = length / 2;
        temp = head;
        if (idxToDelete == 0) {
            return head.next;
        }
        while (idxToDelete-- > 1) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}