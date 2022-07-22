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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
        return head;
        ListNode ans=new ListNode(0);
        ans.next=head;
        ListNode p=ans;
        while(p.next!=null && p.next.next!=null)
        {
        ListNode first=p.next;
        ListNode second=p.next.next;
        first.next=second.next;
        p.next=second;
        second.next=first;
        p=p.next.next;
        }
        return ans.next;
        
    }
}