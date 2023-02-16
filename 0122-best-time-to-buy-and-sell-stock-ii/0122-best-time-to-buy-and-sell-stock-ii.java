class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][]dp=new int[n][2];
        for(int[]a:dp)
            Arrays.fill(a,-1);
        return func(0,1,prices,dp);
        
    }
    
    public int func(int ind,int buy,int[]prices,int[][]dp)
    {
        int profit=0;
        if(ind==prices.length)
            return 0; 
        if(dp[ind][buy]!=-1)
            return dp[ind][buy];
        if(buy==1)
            profit=Math.max(-prices[ind]+func(ind+1,0,prices,dp),func(ind+1,1,prices,dp));
        else
            profit=Math.max(prices[ind]+func(ind+1,1,prices,dp),func(ind+1,0,prices,dp));
        return dp[ind][buy]=profit;
    }
}