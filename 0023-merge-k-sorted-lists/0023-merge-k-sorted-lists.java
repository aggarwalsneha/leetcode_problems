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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null; 
        PriorityQueue<ListNode>q=new PriorityQueue<ListNode>(lists.length,(a,b)-> a.val-b.val);
        
        ListNode ans=new ListNode(0);
        ListNode head=ans;
        
        for(ListNode node:lists){
            if(node!=null)
                q.add(node);
        }
        while(!q.isEmpty()){
            head.next=q.poll();
            head=head.next;
            if(head.next!=null)
                q.add(head.next);
        }
        return ans.next;
    }
}