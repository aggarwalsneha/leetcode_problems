class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n=nums.length;
        int lo=0,hi=nums[n-1]-nums[0];
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(count(nums,mid)>=p)
                hi=mid;
            else
                lo=mid+1;
        }
        return lo;
    }
    
    public int count(int[] nums,int diff){
        int i=0,pairs=0;
        while(i<nums.length-1){
            if(nums[i+1]-nums[i]<=diff){
                pairs++;
                i++;
            }
            i++;
        }
        return pairs;
    }
}