class Solution {
    int mod=(int)1e9+7;
    public int numWays(int steps, int arrLen) {
        arrLen=Math.min(steps,arrLen);
        int[][] dp=new int[arrLen][steps+1];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        return solve(0,steps,arrLen,dp);
    }
    int solve(int curr,int remain,int arrLen,int[][] dp){
        if(remain==0){
            if(curr==0)
                return 1;
            return 0;
        }
        if(dp[curr][remain]!=-1)
            return dp[curr][remain];
        
        int ans=solve(curr,remain-1,arrLen,dp);
        if(curr>0)
            ans=(ans+solve(curr-1,remain-1,arrLen,dp))%mod;
        if(curr<arrLen-1)
            ans=(ans+solve(curr+1,remain-1,arrLen,dp))%mod;
        
        return dp[curr][remain]=ans;
    }
}