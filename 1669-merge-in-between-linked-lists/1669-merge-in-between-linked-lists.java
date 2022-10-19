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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head=list1;
        int i=0;
        ListNode temp=list1;
        int j=1;
        while(j<=b+1)
        {
            temp=temp.next;
            j++;
        }
        while(i<a-1)
        {
            head=head.next;
            i++;
        }
        head.next=list2;
       
        ListNode t=list2;
        while(t.next!=null)
        {
            t=t.next;
        }
        t.next=temp;
        
        return list1;
    }
}