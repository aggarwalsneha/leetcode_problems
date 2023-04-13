class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>st=new Stack<>();
        int i=0;
        for(int num:popped){
            while(st.isEmpty() || (st.peek()!=num && i<pushed.length)){
                st.push(pushed[i++]);
            }
            if(st.peek()==num)
            st.pop();
        }
        if(st.size()==0)
            return true;
        else
            return false;
    }
}