class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0,currMax=0,maxSum=nums[0],currMin=0,minSum=nums[0];
        for(int i:nums)
        {
            currMax=Math.max(currMax+i,i);
            maxSum=Math.max(currMax,maxSum);
            currMin=Math.min(currMin+i,i);
            minSum=Math.min(minSum,currMin);
            total+=i;
        }
        return maxSum>0?Math.max(maxSum,total-minSum):maxSum;
    }
}