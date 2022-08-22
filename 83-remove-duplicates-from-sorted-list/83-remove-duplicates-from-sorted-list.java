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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p=head;
        while(p!=null && p.next!=null)
        {
            if(p.val==p.next.val)
                { 
                // ListNode q=p.next;
                p.next=p.next.next;
                // q.next=null;
                }
            else
            {
                p=p.next;
            }
        }
        return head;
    }
}
