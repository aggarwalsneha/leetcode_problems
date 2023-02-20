/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)
            return head;
        Node ptr=head;
        while(ptr!=null)
        {
            if(ptr.child==null)
            {
                ptr=ptr.next;
                continue;
            }
            Node temp=ptr.child;
            while(temp.next!=null)
                temp=temp.next;
            temp.next=ptr.next;
            if(ptr.next!=null)
                ptr.next.prev=temp;
            ptr.next=ptr.child;
            ptr.child.prev=ptr;
            ptr.child=null;
        }
        return head;
    }
}