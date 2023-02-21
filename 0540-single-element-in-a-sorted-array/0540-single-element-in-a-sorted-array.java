class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)
        return nums[0];
        int N=nums.length;
        for(int i=0;i<N-1;i+=2)
        {
            if(nums[i]!=nums[i+1])
            return nums[i];
        }
        if(nums[N-1]!=nums[N-2])
        return nums[N-1];
        return -1;
    }
}