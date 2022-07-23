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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1=length(l1);
        int n2=length(l2);
        
        ListNode ans=new ListNode(0);
        int carry=0,sum=0;
        while(n1>0 && n2>0)
        {
            sum=0;
            if(n1>=n2)
            {
                sum=sum+l1.val;
                l1=l1.next;
                n1--;
            }
            if(n1<n2)
            {
                sum+=l2.val;
                l2=l2.next;
                n2--;
            }
            
            ListNode head=new ListNode(sum,ans);
            ans=head;
        }
        ListNode temp=ans;
        ans=null;
        carry=0;
        
        while(temp!=null)
        {
            int newsum=temp.val+carry;
            ListNode node=new ListNode(newsum%10,ans);
            carry=(int)newsum/10;
            ans=node;
            temp=temp.next;
        }
        
        return ans.val==0? ans.next:ans;
    }
    
    public int length(ListNode head)
    {
        int len=0;
        while(head!=null)
        {
            head=head.next;
            len++;
        }
        return len;
    }
}