/**
*problem description:
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
此问题的注意点：
需要注意随机数的产生.自己写代码产生随机数，而不是调用库函数获得随机数。有待思考。
随机数的数学原理：
待补充
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 #include <stdlib.h>
 #include <stdio.h>
class Solution {
public:
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    Solution(ListNode* head) {
        this->head=head;
        this->length=0;
        ListNode* node=head;
        while(node!=NULL){
            node=node->next;
            (this->length)++;
        }
    }
    
    /** Returns a random node's value. */
    int getRandom() {
        int ran=rand()%(this->length)+1;
        ListNode * node=head;
        ran--;
        while(ran>0){
            node=node->next;
            ran--;
        }
        return node->val;
    }
private:
    ListNode* head;
    int length;
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
