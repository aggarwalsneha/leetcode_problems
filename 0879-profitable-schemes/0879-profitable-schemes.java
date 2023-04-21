class Solution {
    int mod=1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][]dp=new int[101][101][101];
        for(int i=0;i<=group.length;i++){
            for(int j=0;j<=n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,0,0,n,minProfit,group,profit,dp);
    }
    
    int solve(int ind,int count,int profit,int n,int minProfit,int[] group,int[] profits,int[][][]dp){
        if(ind==group.length)
            return profit>=minProfit?1:0;
        if(dp[ind][count][profit]!=-1)
            return dp[ind][count][profit];
        int total=solve(ind+1,count,profit,n,minProfit,group,profits,dp);
        if(count+group[ind]<=n){
            total+=solve(ind+1,count+group[ind],Math.min(minProfit,profit+profits[ind]),n,minProfit, group,profits,dp);
        }
        return dp[ind][count][profit]=total%mod;
    }
}