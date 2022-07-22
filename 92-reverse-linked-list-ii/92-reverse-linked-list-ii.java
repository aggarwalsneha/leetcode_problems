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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(head==null || head.next==null)
            return head;
        ListNode ans=new ListNode(0);
        ans.next=head;
        ListNode temp=ans;
        ListNode prevL=null;
        
        for(int i=0;i<left;i++)
        {
            prevL=temp;
            temp=temp.next;
        }
        
        
        ListNode curr=temp;
        ListNode prev=prevL;
        for(int i=left;i<=right;i++)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        prevL.next=prev;
        temp.next=curr;
        
        return ans.next;
    }
    
        
    
    
}