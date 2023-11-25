class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)
            prefix[i]=prefix[i-1]+nums[i];
        for(int i=0;i<n;i++){
            int leftSum=prefix[i]-nums[i];
            int rightSum=prefix[n-1]-prefix[i];
            int lDiff=i*nums[i]-leftSum;
            int rDiff=rightSum-(n-1-i)*nums[i];
            ans[i]=lDiff+rDiff;
        }
        return ans;
    }
}