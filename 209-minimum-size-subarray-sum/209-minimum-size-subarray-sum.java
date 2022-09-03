class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result=Integer.MAX_VALUE,i=0,left=0,sum=0;
        for(i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
        while(sum>=target)
        {
            result=Math.min(result,i-left+1);
            sum=sum-nums[left];
            left++;
        }
    }
        return result!=Integer.MAX_VALUE ? result:0;
    }
}