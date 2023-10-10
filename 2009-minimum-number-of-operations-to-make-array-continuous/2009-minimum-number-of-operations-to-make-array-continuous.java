class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int ans=n;
        Set<Integer>hs=new HashSet<>();
        for(int num:nums)
            hs.add(num);
        int[] arr=new int[hs.size()];
        int idx=0;
        for(int num:hs)
            arr[idx++]=num;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int left=arr[i];
            int right=left+n-1;
            int j=bs(arr,right);
            int count=j-i;
            ans=Math.min(ans,n-count);
        }
        return ans;
    }
    
    int bs(int[] arr,int target){
        int left=0;
        int right=arr.length;
        while(left<right){
            int mid=(left+right)/2;
            if(target<arr[mid])
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }
}