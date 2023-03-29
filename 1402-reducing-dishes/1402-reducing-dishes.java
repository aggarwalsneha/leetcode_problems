class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n=satisfaction.length;
        int [][]dp=new int[n+1][n+1];
        for(int[]a:dp)
            Arrays.fill(a,-1);
        return solve(satisfaction,0,0,dp);
    }
    
    public int solve(int[]satisfaction,int ind,int time,int[][]dp)
    {
        if(ind>=satisfaction.length)
            return 0;
        if(dp[ind][time]!=-1)
            return dp[ind][time];
        int pick=satisfaction[ind]*(time+1)+solve(satisfaction,ind+1,time+1,dp);
        int nonpick=solve(satisfaction,ind+1,time,dp);
        return dp[ind][time]=Math.max(pick,nonpick);
    }
}