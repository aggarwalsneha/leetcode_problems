class Solution {
    public int splitArray(int[] nums, int k) {
        int max_el=0,sum=0;
        for(int n:nums){
            max_el=Math.max(max_el,n);
            sum+=n;
        }
        int start=max_el,end=sum;
        while(start<end){
            int mid=start+(end-start)/2;
            int pieces=solve(nums,mid);
            if(pieces<=k)
                end=mid;
            else
                start=mid+1;
        }
        return end;
    }
    
    int solve(int[] nums,int target){
        int pieces=1,sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>target){
                pieces++;
                sum=nums[i];
            }
            else
                sum+=nums[i];
        }
        return pieces;
    }
}