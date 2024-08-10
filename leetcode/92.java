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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode lastBeforeReverse = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            lastBeforeReverse = lastBeforeReverse.next;
        }
        ListNode iter = lastBeforeReverse.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = iter.next;
            iter.next = temp.next;
            temp.next = lastBeforeReverse.next;
            lastBeforeReverse.next = temp;
        }
        return dummyHead.next;
    }
}