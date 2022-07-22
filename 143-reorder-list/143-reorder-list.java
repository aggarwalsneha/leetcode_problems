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
    public void reorderList(ListNode head) {
        ListNode h=cutInHalf(head);
        h=reverse(h);
        ListNode p=head,x;

        while(h!=null)
        {
         x=h.next;
         h.next=p.next;
         p.next=h;
         p=p.next.next;
         h=x;
        }
}

static ListNode cutInHalf(ListNode head)
{
    if(head==null || head.next==null)
    return null;
    ListNode slow=head;
    ListNode fast=head.next;
    while(fast.next!=null && fast.next.next!=null)
    {
        slow=slow.next;
        fast=fast.next.next;
    }
    if(fast.next!=null){
    slow=slow.next;
    }
    ListNode t=slow.next;
    slow.next=null;
    return t;

}

static ListNode reverse(ListNode head)
{
if(head == null){
    return head;
    }
ListNode prev = null,curr = head,next=head.next;
while (curr!= null) {
    next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
}
return prev;
}
        
}