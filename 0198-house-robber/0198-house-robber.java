class Solution {
    public int rob(int[] nums) {
      int[] dp=new int[nums.length];
      if(nums.length==1)
          return nums[0];
     Arrays.fill(dp,-1);
     return solve(0,nums,nums.length,dp);
    }
    
    public int solve(int i,int[] nums,int n,int[] dp)
    {
        if(i>=n)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        return dp[i]=Math.max(nums[i]+solve(i+2,nums,n,dp),solve(i+1,nums,n,dp));
    }
}