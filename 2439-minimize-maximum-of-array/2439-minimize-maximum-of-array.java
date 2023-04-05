class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int num:nums)
            max=Math.max(max,num);
        int left=0,right=max;
        int ans=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(possible(nums,mid)){
                right=mid-1;
                ans=mid;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
    
    public boolean possible(int[] nums,int mid){
        long sum=0;
        for(int n:nums){
            if(n>mid){
                long k=n-mid;
                if(k>sum)
                    return false;
                sum-=k;
            }
            else{
                sum+=(mid-n);
            }
        }
        return true;
    }
}