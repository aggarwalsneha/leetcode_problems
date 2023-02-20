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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1)
            return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=dummy,next=dummy,prev=dummy;
        int len=0;
        while(curr.next!=null)
        {
            len++;
            curr=curr.next;
        }
        while(len>=k)
        {
            curr=prev.next;
            next=curr.next;
            for(int i=1;i<k;i++)
            {
                curr.next=next.next;
                next.next=prev.next;
                prev.next=next;
                next=curr.next;
            }
            prev=curr;
            len-=k;
        }
        return dummy.next;
    }
}