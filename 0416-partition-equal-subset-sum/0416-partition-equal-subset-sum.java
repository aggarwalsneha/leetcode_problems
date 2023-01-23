class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        if(sum%2!=0)
            return false;
        if(nums.length<=1)
            return false;
        int target=sum/2;
        return isSubsetSum(nums.length,nums,target);
    }
    
    public boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean[][] dp=new boolean[N][sum+1];
        for(int i=0;i<N;i++)
        dp[i][0]=true;
        if(arr[0]<sum)
        dp[0][arr[0]]=true;
        for(int ind=1;ind<N;ind++)
        {
            for(int target=1;target<=sum;target++)
            {
                boolean not_pick=dp[ind-1][target];
                boolean pick=false;
                if(arr[ind]<=target)
                pick=dp[ind-1][target-arr[ind]];
                boolean result=pick || not_pick;
                dp[ind][target]=result;
            }
        }
        return dp[N-1][sum];
    }
}