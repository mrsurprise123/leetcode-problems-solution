/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummmyHead = new ListNode(0);
        ListNode p = l1; ListNode q = l2; int carry = 0; 
        ListNode curr = dummmyHead;
        while(p != null || q != null){
            int x = (p != null) ? p->val : 0;
            int y = (q != null) ? q->val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new List(sum % 10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }

        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummmyHead.next;
    }
}