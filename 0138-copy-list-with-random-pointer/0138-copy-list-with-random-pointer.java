/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node iter=head,temp;
        while(iter!=null){
            temp=iter.next;
            Node copy=new Node(iter.val);
            iter.next=copy;
            copy.next=temp;
            iter=temp;
        }
        iter=head;
        while(iter!=null){
            if(iter.random!=null){
                iter.next.random=iter.random.next;
            }
            iter=iter.next.next;
        }
        iter=head;
        Node ans=new Node(0);
        Node copy,copyiter=ans;
        while(iter!=null){
            temp=iter.next.next;
            copy=iter.next;
            copyiter.next=copy;
            copyiter=copy;
            iter.next=temp;
            iter=temp;
        }
        return ans.next;
    }
}