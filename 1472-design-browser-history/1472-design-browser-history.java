class BrowserHistory {
    DLL ll;
    DLL head;
    public BrowserHistory(String homepage) {
        ll=new DLL(homepage);
        head=ll;
    }
    
    public void visit(String url) {
        DLL temp=new DLL(url);
        head.next=temp;
        temp.prev=head;
        head=head.next;
    }
    
    public String back(int steps) {
        while(steps>0 && head.prev!=null)
        {
            head=head.prev;
            steps--;
        }
        return head.data;
    }
    
    public String forward(int steps) {
        while(steps>0 && head.next!=null)
        {
            head=head.next;
            steps--;
        }
        return head.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

class DLL{
    String data;
    DLL prev,next;
    
    DLL(String url)
    {
        data=url;
        prev=null;
        next=null;
    }
}