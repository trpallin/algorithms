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
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode iter = head;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                iter.next = l2;
                l2 = l2.next;
            } else {
                iter.next = l1;
                l1 = l1.next;
            }
            iter = iter.next;
        }
        iter.next = (l1 == null) ? l2 : l1;

        return head.next;
    }

    private ListNode recursiveMerge(ListNode[] lists, int start, int end) {
        if (start == end)
            return lists[start];
        if (start + 1 == end)
            return merge(lists[start], lists[end]);

        int mid = start + (end - start) / 2;
        ListNode left = recursiveMerge(lists, start, mid);
        ListNode right = recursiveMerge(lists, mid+1, end);

        return merge(left, right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return recursiveMerge(lists, 0, lists.length - 1);
    }

    // private int getMinIdx(int[] minVals) {
    //     int idx = -1;
    //     int minVal = Integer.MAX_VALUE;

    //     for (int i = 0; i < minVals.length; ++i) {
    //         if (minVal > minVals[i]) {
    //             idx = i;
    //             minVal = minVals[i];
    //         }
    //     }

    //     return idx;
    // }

    // private boolean notAllListsEmpty(int[] minVals) {
    //     for (int i = 0; i < minVals.length; ++i) {
    //         if (minVals[i] < Integer.MAX_VALUE) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // public ListNode mergeKLists(ListNode[] lists) {
    //     int[] minVals = new int[lists.length];
    //     ListNode head = new ListNode();
    //     ListNode iter = head;
    //     for (int i = 0; i < lists.length; ++i) {
    //         if (lists[i] == null) {
    //             minVals[i] = Integer.MAX_VALUE;
    //         } else {
    //             minVals[i] = lists[i].val;
    //         }
    //     }
    //     while (notAllListsEmpty(minVals)) {
    //         int minIdx = getMinIdx(minVals);
    //         iter.next = lists[minIdx];
    //         lists[minIdx] = lists[minIdx].next;
    //         if (lists[minIdx] == null) {
    //             minVals[minIdx] = Integer.MAX_VALUE;
    //         } else {
    //             minVals[minIdx] = lists[minIdx].val;
    //         }
    //         iter = iter.next;
    //     }
    //     head = head.next;
    //     return head;
    // }
}