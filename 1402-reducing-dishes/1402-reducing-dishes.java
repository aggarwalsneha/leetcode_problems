class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n=satisfaction.length;
        int [][]dp=new int[n+1][n+1];
        for(int ind=n-1;ind>=0;ind--)
        {
            for(int time=ind;time>=0;time--)
            {
                int pick=satisfaction[ind]*(time+1)+dp[ind+1][time+1];
                int nonpick=dp[ind+1][time];
                dp[ind][time]=Math.max(pick,nonpick);
            }
        }
        return dp[0][0];
    }
}