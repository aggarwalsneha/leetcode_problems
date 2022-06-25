class MyLinkedList {

    
    class Node
    {
        int val;
        Node next;
        
        Node(int val)
        {
            this.val=val;
            this.next=null;
        }
    }
        
    private Node head;
    private int len;
    public MyLinkedList() {

    }
    
    public int get(int index) {
      
        if(index>=len)
            return -1;
        Node q=head;
       for(int i=0;i<index;i++)
        {
            q=q.next;
        }
        return q.val;   
    }
    
    public void addAtHead(int val) {
        Node p=new Node(val);
        len++;
        if(head==null)
        {
            head=p;
            return ;
        }
        p.next=head;
        head=p;
    }
    
    
    
    public void addAtTail(int val) {
        Node p=new Node(val);
        Node temp=head;
         len++;
          if(head==null)
        {
            head=p;
            return ;
        }
        while(temp.next!=null)
            temp=temp.next;
        temp.next=p;
    }
    
    public void addAtIndex(int index, int val) {
        if(index>len)
            return;
        
        if(index==0)
        {
            addAtHead(val);
        }
        else{
            len++;
        
        Node p=new Node(val);
        Node temp=head;
        for(int i=0;i<index-1;i++)
        {
           temp=temp.next;
        }
        p.next=temp.next;
        temp.next=p;
            
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index>=len)
            return;
        len--;
        if(index==0)
            head=head.next;
        else{
            Node p=head;
            Node q=null;
        for(int i=0;i<index-1;i++)
        {
           p=p.next;
        }
            q=p.next;
            p.next=q.next;
        }  
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */