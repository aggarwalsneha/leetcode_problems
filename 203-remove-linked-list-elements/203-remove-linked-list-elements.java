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
    public ListNode removeElements(ListNode head, int val) {
        ListNode p=head;
        if(head==null)
            return null;
        if(p.next==null && p.val==val)
            return null;
        while(p!=null)
        {
             if (head.val == val)
                 head = head.next;
            if(p.next!=null && p.next.val==val)
            {
                p.next=p.next.next;
            }
            else
            p=p.next;
        }
        return head;
    }
}

