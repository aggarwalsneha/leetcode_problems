class Solution {
    public int[] countBits(int n) {
        int[] res=new int[n+1]; 
        
        for(int i=0;i<=n;i++){ 
            res[i]=solve(i,res);
        }
        return res;
    }
    
    public int solve(int n,int[] dp){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(dp[n]!=0)
            return dp[n];
        if(n%2==0)
            return dp[n]=solve(n/2,dp);
        else
            return dp[n]=1+solve(n/2,dp);
    }
}