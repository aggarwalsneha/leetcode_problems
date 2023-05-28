class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[] newCuts=new int[m+2];
        System.arraycopy(cuts,0,newCuts,1,m);
        newCuts[m+1]=n;
        Arrays.sort(newCuts);
        int[][] dp=new int[m+1][m+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        return solve(1,m,newCuts,dp);
    }
    
    int solve(int i,int j,int[] cuts,int[][] dp){
        if(i>j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int mini=Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost=cuts[j+1]-cuts[i-1]+solve(i,ind-1,cuts,dp)+solve(ind+1,j,cuts,dp); 
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }
}