class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n=obstacles.length,len=0;
        int[] ans=new int[n],lis=new int[n];
        for (int i=0;i<n;i++){
            int height=obstacles[i];
            int idx=bisectRight(lis,height,len);
            if(idx==len)
                len++;
            lis[idx]=height;
            ans[i]=idx+1;
        }
        return ans;
    }
    int bisectRight(int[] arr,int target,int right){
        if(right==0)
            return 0;
        int left=0;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]<=target)
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
}