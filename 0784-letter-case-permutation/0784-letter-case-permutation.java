class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        permute(s,ans,0);
        return ans;
    }
    
    public void permute(String s,List<String> ans,int start)
    {
        if(start==s.length()){
            ans.add(s);
            return;
        }
        
        if(Character.isDigit(s.charAt(start)))
        {
            permute(s,ans,start+1);
            return ;
        }
        s=s.substring(0,start)+Character.toLowerCase(s.charAt(start))+s.substring(start+1,s.length());
        permute(s,ans,start+1);
        s=s.substring(0,start)+Character.toUpperCase(s.charAt(start))+s.substring(start+1,s.length());
        permute(s,ans,start+1);
    }
}