class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n=cost.length;
        int[][] dp=new int[n][n+1];
        return solve(0,n,cost,time,dp);
    }
    
    public int solve(int i,int remain,int[] cost,int[] time,int[][] dp){
        if(remain<=0)
            return 0;
        if(i==cost.length)
            return (int) 1e9;
        
        if(dp[i][remain]!=0)
            return dp[i][remain];
        int paint=cost[i]+solve(i+1,remain-1-time[i],cost,time,dp);
        int dontpaint=solve(i+1,remain,cost,time,dp);
        
        dp[i][remain]=Math.min(paint,dontpaint);
        return dp[i][remain];
    }
}