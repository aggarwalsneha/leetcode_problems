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
        if(head==null || head.next==null)
            return head;
        ListNode ans=new ListNode(Integer.MIN_VALUE);
        ans.next=head;
        head=ans;
        
        ListNode left=head,right=head;
        while(right!=null)
        {
            if(left.val==right.val)
                right=right.next;
            else if(left.next==right){
                ans.next=left;
                ans=left;
                left=right;
            }
            else
                left=right;
            
        }
        if(left.next!=null)
            ans.next=null;
        else
            ans.next=left;
        return head.next;
        
    }
}