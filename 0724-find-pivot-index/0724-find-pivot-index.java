class Solution {
    public int pivotIndex(int[] nums) {
     int totalSum=0;
        int currSum=0;
        for(int i=0;i<nums.length;i++)
            totalSum+=nums[i];
        for(int i=0;i<nums.length;i++)
        {
            totalSum-=nums[i];
            if(currSum==totalSum)
                return i;
            currSum+=nums[i];
        }
        return -1;
    }
}