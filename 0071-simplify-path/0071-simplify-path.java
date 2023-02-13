class Solution {
    public String simplifyPath(String path) {
        Stack<String>st=new Stack<>();
        int n=path.length();
        if(path.charAt(n-1)!='/'){
            path+='/';
            n+=1;
        }
        String temp="";
        String ans="";
        int i=1;
        for(i=1;i<n;i++)
        {
            if(path.charAt(i)=='/')
            {
                if(temp.equals("") || temp.equals(".")){
                    temp="";
                    continue;
                }
                if(temp.equals("..")){
                    if(!st.isEmpty())
                        st.pop();
                    temp="";
                }
                else{   
                    st.push(temp);
                    temp="";
                }
            }
            else
                temp+=path.charAt(i);
        }
        while(!st.isEmpty())
            ans='/'+st.pop()+ans;
        if(ans.equals(""))
            return "/";
        return ans;
    }
}