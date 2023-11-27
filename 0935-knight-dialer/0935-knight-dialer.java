class Solution {
    int[][] jumps={{4, 6},{6, 8},{7, 9},{4, 8},{3, 9, 0},{},{1, 7, 0},{2, 6},{1, 3},{2, 4}};
    int mod=(int)1e9+7;
    public int knightDialer(int n) {
        int[][] dp=new int[n+1][10];
        int ans=0;
        for(int i=0;i<10;i++)
            ans=(ans+solve(n-1,i,dp))%mod;
        return ans;
    }
    
    public int solve(int remain,int i,int[][] dp){
        if(remain==0)
            return 1;
        if(dp[remain][i]!=0)
            return dp[remain][i];
        int ans=0;
        for(int next:jumps[i])
            ans=(ans+solve(remain-1,next,dp))%mod;
        
        return dp[remain][i]=ans;
    }
}