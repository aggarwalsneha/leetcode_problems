class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][]dp=new int[n][2][3];
        for(int[][] arr:dp)
            for(int[]a:arr)
            Arrays.fill(a,-1);
        return func(0,1,2,prices,dp);
    }
    public int func(int ind,int buy,int count,int[]prices,int[][][]dp)
    {
        if(ind==prices.length)
            return 0;
        if(count==0)
            return 0;
        if(dp[ind][buy][count]!=-1)
            return dp[ind][buy][count];
        int profit=0;
        if(buy==1)
            profit=Math.max(-prices[ind]+func(ind+1,0,count,prices,dp),func(ind+1,1,count,prices,dp));
        else
            profit=Math.max(prices[ind]+func(ind+1,1,count-1,prices,dp),func(ind+1,0,count,prices,dp));
        return dp[ind][buy][count]=profit;
    }
}