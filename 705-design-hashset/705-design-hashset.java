
class MyHashSet {
ListNode head=null;
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        if(head==null)
            head=new ListNode(key);
        else
        {
            ListNode node=new ListNode(key);
            ListNode temp=head;
            boolean present=false;
            while(temp.next!=null)
            {
                if(temp.val==key){
                    present=true;
                    break;
                }
                temp=temp.next;
            }
            if(!present && temp.val!=key)
                temp.next=node;
        }
    }
    
    public void remove(int key) {
        if(head!=null && head.val==key)
            head=head.next;
        else
        {
            ListNode temp=head;
            while(temp!=null && temp.next!=null)
            {   if(temp.next.val==key)
                    temp.next=temp.next.next;
                temp=temp.next;
            }
        }
    }
    
    public boolean contains(int key) {
        ListNode temp=head;
        while(temp!=null)
        {
            if(temp.val==key)
                return true;
            temp=temp.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */