//
// Created by andy on 17-3-17.
//

//complexity: time O(n) ,space O(1)

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
    bool hasCycle(ListNode *head) {
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
                return false;
            }
            if(ptr1 == ptr2){
                break;
            }
        }
        return true;
    }
};