class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int firstMax=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        int firstMin=Integer.MAX_VALUE;
        int secondMin=Integer.MAX_VALUE;
        
        for(int n:nums1){
            firstMax=Math.max(firstMax,n);
            firstMin=Math.min(firstMin,n);
        }
        for(int n:nums2){
            secondMax=Math.max(secondMax,n);
            secondMin=Math.min(secondMin,n);
        }
        
        if(firstMax<0 && secondMin>0)
            return firstMax*secondMin;
        
        if (firstMin>0 && secondMax<0)
            return firstMin*secondMax;
        
        int[][]dp=new int[nums1.length][nums2.length];
        return solve(0,0,nums1,nums2,dp);
    }
    
      public int solve(int i,int j,int[] nums1,int[] nums2,int[][] dp) {
        if(i==nums1.length || j==nums2.length)
            return 0;
        if(dp[i][j]!=0)
            return dp[i][j];
        int pick=nums1[i]*nums2[j]+solve(i+1,j+1,nums1,nums2,dp);
        dp[i][j]=Math.max(pick,Math.max(solve(i+1,j,nums1,nums2,dp),solve(i,j+1,nums1,nums2,dp)));
        return dp[i][j];
      }
}