/**
Probem description:
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

思路：从头开始相加接即可，只是要注意考虑进位

更简洁的代码：
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//可以直接加上头结点，返回时去掉即可。
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        //用取模比相减好多了。
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    //返回时不带上头结点
    return dummyHead.next;
}
*/

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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *first=l1,*second=l2;
        //current:当前进位的值,0或1
        //carry：为下一位准备的进位值。
        int carry=0,current=0;
        ListNode * result=NULL,*head=NULL;
        while(first&&second){
            //直接使用current即可。
            int tmp=first->val+second->val+current;
            if(tmp>=10){
                tmp=tmp-10;
                carry=1;
            }
            first=first->next;
            second=second->next;
            if(result==NULL){
                result=new ListNode(tmp);
                head=result;
            }
            else{
                head->next=new ListNode(tmp);
                head=head->next;
            }
            //current为下一次做准备，carry重置。
            current=carry;
            carry=0;
        }
        //这里不直接将剩余的first或second链表连接进来，
        //因为不能确定l1,l2什么时候回释放，导致问题。
        while(first){
            int tmp=first->val+current;
            if(tmp>=10){
                tmp-=10;
                carry=1;
            }
            head->next=new ListNode(tmp);
            head=head->next;
            first=first->next;
            current=carry;
            carry=0;
            }
        while(second){
            int tmp=second->val+current;
            if(tmp>=10){
                tmp=tmp-10;
                carry=1;
            }
            head->next=new ListNode(tmp);
            head=head->next;
            second=second->next;
            current=carry;
            carry=0;
            }
      if(current==1){
            head->next=new ListNode(1);
        }
        return result;
    }
};
