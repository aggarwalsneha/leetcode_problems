class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        if(n==0)
            return false;
        int lo=0,hi=n-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(nums[mid]==target)
                return true;
            if(nums[lo]==nums[mid] && nums[hi]==nums[mid]){
                lo++;
                hi--;
            }
            else if(nums[lo]<=nums[mid]){
                if(nums[lo]<=target && target<nums[mid])
                    hi=mid-1;
                else
                    lo=mid+1;
            }
            else{
                if(nums[mid]<target && nums[hi]>=target)
                    lo=mid+1;
                else
                    hi=mid-1;
            }
        }
        return false;
    }
}