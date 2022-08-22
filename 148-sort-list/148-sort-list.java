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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode mid=getMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        
        return mergeList(left,right);
    }
    
    public ListNode getMid(ListNode head)
    {
        ListNode slow=null;
        while(head!=null && head.next!=null)
        {
            slow=(slow==null)? head : slow.next;
            head=head.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        return mid;
    }
    
    public ListNode mergeList(ListNode list1,ListNode list2)
    {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
      
        ListNode temp1=list1;
        ListNode temp2=list2;
        
        
        ListNode result=new ListNode(0);
        ListNode head=result;
        
            while(temp1!=null || temp2!=null)
            {
                if(temp2==null || (temp1!=null && temp1.val<temp2.val))
                {
                    result.next=temp1;
                    temp1=temp1.next;
                    result=result.next;
                }        
                else
                {
                    result.next=temp2;
                    temp2=temp2.next;
                    result=result.next;
                }
            }
        return head.next;
    }
}