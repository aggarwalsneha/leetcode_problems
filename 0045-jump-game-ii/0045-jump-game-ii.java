class Solution {
    public int jump(int[] nums) {
        int ans=0,n=nums.length;
        int curEnd=0,curFar=0;
        
        for (int i=0;i<n-1;i++) {
            curFar = Math.max(curFar,i+nums[i]);
            if (i==curEnd){
                ans++;
                curEnd=curFar;
            }
        }    
        return ans;
    }
}