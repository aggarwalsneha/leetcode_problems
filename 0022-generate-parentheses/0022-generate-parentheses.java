class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>();
        int open=n,close=n;
        String curr="";
        solve(open,close,curr);
        return ans;
    }
    
    void solve(int open,int close,String curr)
    {
        if(open==0 && close==0){
            ans.add(curr);
            return;
        }
        if(open>0)
        {
            String str=curr;
            str+='(';
            solve(open-1,close,str);
        }
        if(close>open)
        {
            String str2=curr;
            str2+=')';
            solve(open,close-1,str2);
        }
        
    }
}