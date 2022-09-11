class MyStack {
Queue<Integer> q1=new LinkedList<>();
 Queue<Integer> q2=new LinkedList<>();
    int top;    
    public MyStack() {
        
    }
    
    public void push(int x) {
        q2.add(x);
        top=x;
        while(!q1.isEmpty())
            q2.add(q1.remove());
        Queue<Integer>temp=q1;
        q1=q2;
        q2=temp;
    }
    
    public int pop() {
        int ans=q1.remove();
        if(!q1.isEmpty())
            top=q1.peek();
        return ans;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */