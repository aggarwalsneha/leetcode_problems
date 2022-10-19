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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode start = head;
        ListNode end = head;
        ListNode t = head;
        int i=1;
        while(i<k){
            start=start.next;
            t=t.next;
            i++;
        }
        while(t.next!=null){
            t=t.next;
            end=end.next;
        }
        int temp = start.val;
        start.val = end.val;
        end.val = temp;
    return head;
        
    }
}