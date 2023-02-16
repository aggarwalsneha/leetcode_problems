class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][]dp=new int[n+1][2][3];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int count=1;count<=2;count++){
                    if(buy==1)
                        dp[ind][buy][count]=Math.max(-prices[ind]+dp[ind+1][0][count],dp[ind+1][1][count]);
                    else
                        dp[ind][buy][count]=Math.max(prices[ind]+dp[ind+1][1][count-1],dp[ind+1][0][count]);
                }
            }
        }
        return dp[0][1][2];
    }
}