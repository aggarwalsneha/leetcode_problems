class Solution {
    public int change(int amount, int[] coins) {
        int N=coins.length;
        int[][] dp=new int[N+1][amount+1];
        for(int[] a:dp)
        Arrays.fill(a,-1);
        return solve(N-1,amount,coins,dp);
    }
    static int solve(int i,int sum,int coins[],int[][] dp){
        if(i<0){
           if(sum==0)
           return 1;
           else
           return 0;
       }
       if(dp[i][sum]!=-1)
       return dp[i][sum];
       
       int take = 0;
       int nottake=0;
       if(coins[i]<=sum){
           take=solve(i,sum-coins[i],coins,dp);
       }
        nottake=solve(i-1,sum,coins,dp);
        return dp[i][sum]=take+nottake;
    }
}