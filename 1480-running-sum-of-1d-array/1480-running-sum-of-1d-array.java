class Solution {
    public int[] runningSum(int[] nums) {
      int[] ans=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum=sum+nums[i];
        for(int i=nums.length-1;i>=0;i--)
        {
            ans[i]=sum;
            sum=sum-nums[i];
        }
        return ans;
    }
}