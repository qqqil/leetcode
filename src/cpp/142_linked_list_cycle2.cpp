//
// Created by andy on 17-3-17.
//

//complexity:time O(n),space O（1）

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode *ptr1 = head;
        ListNode *ptr2 = head;
        while(true){
            if(ptr1 != nullptr)
                ptr1 = ptr1->next;
            if(ptr2 != nullptr)
                ptr2 = ptr2->next;
            if(ptr2 != nullptr)
                ptr2 = ptr2->next;
            if(ptr1 == nullptr || ptr2 ==nullptr){
                return nullptr;
            }
            if(ptr1 == ptr2){
                break;
            }
        }
        ptr2 = head;
        while(true){
            if(ptr2 == ptr1){
                return ptr1;
            }
            ptr2 = ptr2->next;
            ptr1 = ptr1->next;

        }
        return nullptr;
    }
};