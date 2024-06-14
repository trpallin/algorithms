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
    public ListNode swapPairs(ListNode head) {
        ListNode iter;

        if (head != null && head.next != null) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = head;
            head = temp;
            iter = head.next;
        } else {
            return head;
        }

        while (iter != null) {
            if (iter.next != null && iter.next.next != null) {
                ListNode temp = iter.next;
                iter.next = iter.next.next;
                temp.next = iter.next.next;
                iter.next.next = temp;
                iter = temp;
            } else {
                break;
            }
        }

        return head;
    }
}