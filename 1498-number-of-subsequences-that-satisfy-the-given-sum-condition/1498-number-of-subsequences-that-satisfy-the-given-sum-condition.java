class Solution {
    public int numSubseq(int[] nums, int target) {
        int n=nums.length;
        int mod=1000000007;
        Arrays.sort(nums);
        int[] power=new int[n];
        power[0]=1;
        for(int i=1;i<n;i++){
            power[i]=(power[i-1]*2)%mod;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int j=binarySearch(nums,target-nums[i])-1;
            if(j>=i){
                ans+=power[j-i];
                ans%=mod;
            }
        }
        return ans;
    }
    public static int binarySearch(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}