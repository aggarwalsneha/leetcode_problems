class MyQueue {
public Stack<Integer> s1=new Stack<>();
    public Stack<Integer> s2=new Stack<>();
    int top=-1;
    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(s1.empty())
            top=x;
        while(!s1.isEmpty())
            s2.push(s1.pop());
        s2.push(x);
        while(!s2.isEmpty())
            s1.push(s2.pop());
    }
    
    public int pop() {
        int ans=s1.pop();
        if(!s1.isEmpty())
            top=s1.peek();
        return ans;
        
    }
    
    public int peek() {
        return top;
        
    }
    
    public boolean empty() {
        return s1.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */