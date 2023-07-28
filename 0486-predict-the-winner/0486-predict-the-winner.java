class Solution {
    public boolean PredictTheWinner(int[] nums) {
     int n=nums.length;
        int[][] dp=new int[n][n];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        return solve(nums,0,n-1,dp)>=0;
    }
    
    public int solve(int[] nums,int i,int j,int[][] dp){
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(i==j)
            return nums[i];
        int left=nums[i]-solve(nums,i+1,j,dp);
        int right=nums[j]-solve(nums,i,j-1,dp);
        return dp[i][j]=Math.max(left,right);
    }
}