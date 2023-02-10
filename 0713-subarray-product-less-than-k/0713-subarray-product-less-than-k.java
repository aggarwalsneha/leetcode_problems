class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long prod=1;
        int count=0,i=0,j=0;
        if(k<=1)
            return 0;
        for(j=0;j<nums.length;j++)
        {
            prod=prod*nums[j];
            while(prod>=k)
                prod/=nums[i++];
            count+=j-i+1;
        }
        return count;
    }
}