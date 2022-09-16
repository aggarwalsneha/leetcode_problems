class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<operations.length;i++)
        {
            if(operations[i].equals("+")){
                int top=st.pop();
                int newt=top+st.peek();
                st.push(top);
                st.push(newt);
            }
            else if(operations[i].equals("C"))
                st.pop();
             else if(operations[i].equals("D"))
                st.push(2*st.peek());
            else
                st.push(Integer.valueOf(operations[i]));
            
        }
        int ans=0;
        while(!st.isEmpty())
            ans=ans+st.pop();
        return ans;
    }
}