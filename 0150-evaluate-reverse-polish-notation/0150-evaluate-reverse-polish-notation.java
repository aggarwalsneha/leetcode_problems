class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for(int i=0;i<tokens.length;i++)
        {
           if(tokens[i].equals("+"))
            {
                st.push(st.pop()+st.pop());
            }
            else if(tokens[i].equals("-"))
            {
                int A=st.pop();
                int B=st.pop();
                int res=B-A;
                st.push(res);
            }
            else if(tokens[i].equals("*"))
            {
                st.push(st.pop()*st.pop());
            }
            else if(tokens[i].equals("/"))
            {
                int A=st.pop();
                int B=st.pop();
                int res=B/A;
                st.push(res);
            }
            else
            st.push(Integer.valueOf(tokens[i]));
        }
        return st.pop();
    }
}