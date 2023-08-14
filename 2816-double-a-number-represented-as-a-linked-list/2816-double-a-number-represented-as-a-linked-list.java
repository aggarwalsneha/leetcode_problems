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
    public ListNode doubleIt(ListNode head) {
        head=reverse(head);
        int c=0;
        ListNode ptr=head;
        while(ptr!=null){
            int t=ptr.val*2;
            ptr.val=(t+c)%10;
            c=(t+c)/10;
            if(ptr.next==null && c!=0){
                ptr.next=new ListNode(c);
                ptr=ptr.next;
            }
            ptr=ptr.next;
        }
        return reverse(head);
    }
    
    public ListNode reverse(ListNode head){
        if(head==null)
            return null;
        ListNode curr=head,prev=null,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}