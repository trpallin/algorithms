/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* head;
        ListNode* curr;
        ListNode *iter1, *iter2;
        if (list1 == nullptr) return list2;
        if (list2 == nullptr) return list1;

        if (list1->val < list2->val) {
            head = list1;
            iter1 = list1->next;
            iter2 = list2;
        } else {
            head = list2;
            iter1 = list1;
            iter2 = list2->next;
        }
        curr = head;

        while (iter1 != nullptr && iter2 != nullptr) {
            if (iter1->val < iter2->val) {
                curr->next = iter1;
                curr = iter1;
                iter1 = iter1->next;
            } else {
                curr->next = iter2;
                curr = iter2;
                iter2 = iter2->next;
            }
        }
        if (iter1 == nullptr) {
            curr->next = iter2;
        } else {
            curr->next = iter1;
        }
        return head;
    }
};