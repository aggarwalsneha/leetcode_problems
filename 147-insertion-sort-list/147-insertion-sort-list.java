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
    public ListNode insertionSortList(ListNode head) {
        ListNode ans=new ListNode(-1);
        ans.next=head;
        ListNode curr=head,prev=ans.next;
        
        while(curr!=null)
        {
         if(curr.val>=prev.val)
         {
             prev=curr;
             curr=curr.next;
             continue;
         }
            ListNode temp=ans;
            while(curr.val>temp.next.val)
            {
                temp=temp.next;
            }
            
            prev.next=curr.next;
            curr.next=temp.next;
            temp.next=curr;
            curr=prev.next;
            
        }
        return ans.next;
    }
}