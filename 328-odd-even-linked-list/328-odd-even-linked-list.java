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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode oddHead=new ListNode(0);
        ListNode evenHead=new ListNode(0);
        
        ListNode odd=oddHead;
        ListNode even=evenHead;
        
        while(head!=null && head.next!=null)
        {
            odd.next=head;
            odd=odd.next;
            head=head.next;
            even.next=head;
            even=even.next;
            head=head.next;       
        }
        if(head!=null){
            odd.next=head;
        odd=odd.next;
        }
        even.next=null;
        odd.next=evenHead.next;
        
        return oddHead.next;
        
    }
}