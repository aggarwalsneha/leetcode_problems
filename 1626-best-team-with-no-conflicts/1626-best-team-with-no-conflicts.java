class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=ages.length;
        int[][] pairs=new int[n][2];
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++)
        {
            pairs[i][0]=ages[i];
            pairs[i][1]=scores[i];
        }
        Arrays.sort(pairs,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        return solve(pairs,0,-1,dp);
    }
    public int solve(int[][]pair,int ind,int prev,int[][]dp)
    {
        if(ind>=pair.length)
            return 0;
        if(dp[prev+1][ind]!=0)
            return dp[prev+1][ind];
        if(prev==-1 || pair[ind][1]>=pair[prev][1])
            return dp[prev+1][ind]=Math.max(solve(pair,ind+1,prev,dp),pair[ind][1]+solve(pair,ind+1,ind,dp));
        return dp[prev+1][ind]=solve(pair,ind+1,prev,dp);
    }
}