class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st=new Stack<>();
        for(int a:asteroids){
            boolean flag=true;
             while(!st.isEmpty() && st.peek()>0 && a<0){
                 if(Math.abs(st.peek())<Math.abs(a)){
                     st.pop();
                     continue;
                 }
                 else if(Math.abs(st.peek())==Math.abs(a))
                     st.pop();
                 
                 flag=false;
                 break;
             }
            if(flag)
                st.push(a);
        }
        int[] rem=new int[st.size()];
        for(int i=rem.length-1;i>=0;i--)
            rem[i]=st.pop();
        
        return rem;
    }
}