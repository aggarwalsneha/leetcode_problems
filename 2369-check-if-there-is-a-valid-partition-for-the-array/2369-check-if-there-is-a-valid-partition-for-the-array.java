class Solution {
    public boolean validPartition(int[] nums) {
        int n=nums.length;
        boolean[]dp=new boolean[n+1];
        dp[0]=true;
        for(int i=2;i<=n;i++){
            if(i>=2){
                if(nums[i-1]==nums[i-2]){
                    dp[i]|=dp[i-2];
                }
            }
            if(i>=3){
                if(nums[i-1]==nums[i-2] && nums[i-2]==nums[i-3]){
                    dp[i]|=dp[i-3];
                }
                else if(nums[i-1]==nums[i-2]+1 && nums[i-2]==nums[i-3]+1){
                    dp[i]|=dp[i-3];
                }
            }
        }
        return dp[n];
    }
}