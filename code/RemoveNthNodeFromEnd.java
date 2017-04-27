package code;
/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode headPre = new ListNode(-1);
        headPre.next = head;
        ListNode start = headPre, end = headPre;
        for (int i = 1; i <= n + 1; i++) {
            end = end.next;
        }
        while (end != null) {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return headPre.next;
        // List<ListNode> listNodeList = new ArrayList<>();
        // ListNode p = head;
        // while (p != null) {
        //     listNodeList.add(p);
        //     p = p.next;
        // }
        // if (n == listNodeList.size())
        //     return listNodeList.get(0).next;
        // if (listNodeList.size() == 1)
        //     return null;
        // int pos = listNodeList.size() - n;
        // listNodeList.get(pos - 1).next =
        //         listNodeList.get(pos).next;
        // return  listNodeList.get(0);
    //   int len = 0;
    //     ListNode p = new ListNode(0);
    //     p.next = head;
    //     ListNode tmp = p;
    //     while (tmp != null) {
    //         len++;
    //         tmp = tmp.next;
    //     }
    //     ListNode pre = p;
    //     ListNode cur = pre.next;
    //     int count = 0;
    //     while (count < len - n - 1) {
    //         count++;
    //         pre = cur;
    //         cur = cur.next;
    //     }
    //     pre.next = cur.next;
    //     return p.next;  
    }
}
