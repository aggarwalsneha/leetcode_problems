class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        if(n<d)
            return -1;
        int[][] dp=new int[n][d+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);

        return dfs(d,0,jobDifficulty,dp);
    }
    public int dfs(int d,int len,int[] jobDifficulty,int[][] dp){
        int n=jobDifficulty.length;
        if(d==0 && len==n)
            return 0;
        if(d==0 || len==n)
            return Integer.MAX_VALUE;
        if(dp[len][d]!=-1)
            return dp[len][d];
        int curMax=jobDifficulty[len];
        int min=Integer.MAX_VALUE;
        for(int schedule=len;schedule<n;schedule++){
            curMax=Math.max(curMax,jobDifficulty[schedule]);
            int temp=dfs(d-1,schedule+1,jobDifficulty,dp);
            if(temp!=Integer.MAX_VALUE)
                min=Math.min(min,temp+curMax);
        }
        return dp[len][d]=min;
    }
}