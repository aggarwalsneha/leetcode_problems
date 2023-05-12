class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] dp=new long[n];
        return solve(questions,0,dp);
    }
    public long solve(int[][] questions,int i,long[] dp){
        if (i>=questions.length){
            return 0;
        }
        if(dp[i]!=0){
            return dp[i];
        }
        long points=questions[i][0];
        int skip=questions[i][1];
        dp[i]=Math.max(points+solve(questions,i+skip+1,dp),solve(questions,i+1,dp));
        return dp[i];
    }
}