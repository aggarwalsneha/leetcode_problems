class Solution {
    int[][][] dp;
    int mod=1000000007;
    int n,m;
    public int numOfArrays(int n, int m, int k) {
        dp=new int[n][m+1][k+1];
        for(int[][] arr:dp){
            for(int[] a:arr)
                Arrays.fill(a,-1);
        }
        this.n=n;
        this.m=m;
        return solve(0,0,k);
    }
    
    public int solve(int i,int max,int remain){
        if(i==n){
            if(remain==0)
                return 1;
            return 0;
        }
        if(remain<0)
            return 0;
        if(dp[i][max][remain]!=-1)
            return dp[i][max][remain];
        int ans=0;
        for(int j=1;j<=max;j++)
            ans=(ans+solve(i+1,max,remain))%mod;
        for(int j=max+1;j<=m;j++)
            ans=(ans+solve(i+1,j,remain-1))%mod;
        
        dp[i][max][remain]=ans;
        
        return ans;
    }
}