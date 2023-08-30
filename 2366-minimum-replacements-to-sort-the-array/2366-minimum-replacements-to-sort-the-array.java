class Solution {
    public long minimumReplacement(int[] nums) {
        long ans=0;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1])
                continue;
            long count=(long)(nums[i]+nums[i+1]-1)/nums[i+1];
            ans+=count-1;
            nums[i]=nums[i]/(int)count;
        }
        return ans;
    }
}