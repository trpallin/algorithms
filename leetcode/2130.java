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
    public int pairSum(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        ListNode secondHalf = head;
        int halfLen = length / 2;
        while (halfLen-- > 0) {
            secondHalf = secondHalf.next;
        }
        ListNode reverseHead = null;
        while (secondHalf != null) {
            ListNode next = secondHalf.next;
            secondHalf.next = reverseHead;
            reverseHead = secondHalf;
            secondHalf = next;
        }
        int maxTwinSum = 0;
        while (reverseHead != null) {
            int sum = head.val + reverseHead.val;
            maxTwinSum = Math.max(maxTwinSum, sum);
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return maxTwinSum;
    }
}