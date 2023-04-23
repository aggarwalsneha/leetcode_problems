class Solution {
    int mod=1000000007;
    public int numberOfArrays(String s, int k) {
        int n=s.length();
        int[] dp=new int[n+1];
        return dfs(dp,0,s,k);
    }
    int dfs(int[] dp,int ind,String s,int k){
        if(dp[ind] != 0)
            return dp[ind];
        if(ind==s.length())
            return 1;
        if(s.charAt(ind)=='0')
            return 0;
        int count=0;
        for(int i=ind;i<s.length();i++){
            String curr=s.substring(ind,i+1);
            if (Long.parseLong(curr)>k)
                break;
            count=(count+dfs(dp,i+1,s,k))%mod;
        }
        dp[ind]=count;
        return count;
    }
}