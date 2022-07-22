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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0,k;

        ListNode p=new ListNode(123);
        ListNode ans=p;
        while(l1!=null && l2!=null)
        {
        k=l1.val + l2.val + carry;
        carry= (int)k/10;
        p.next=new ListNode(k%10);
        p=p.next;
        l1=l1.next;
        l2=l2.next;
        }
        if(l2!=null)
        {
            l1=l2;
        }
        while(l1!=null)
        {
        k=l1.val + carry;
        carry= (int)k/10;
        p.next=new ListNode(k%10);
        p=p.next;
        l1=l1.next;
        }
        if(carry!=0)
        {
            p.next=new ListNode(carry);
        }
        return ans.next;
        
    }
}