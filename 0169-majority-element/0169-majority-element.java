class Solution {
    public int majorityElement(int[] nums) {
        int maj=-1,cnt=0;
        for(int i=0;i<nums.length;i++)
        {
            if(cnt==0)
                maj=nums[i];
            if(nums[i]!=maj)
                cnt--;
            else
                cnt++; 
        }
        return maj;
    }
}