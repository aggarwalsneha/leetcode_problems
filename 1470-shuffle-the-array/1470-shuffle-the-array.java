class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[nums.length];
        int lo=0,hi=n;
        int i=0;
        while(lo<=n && hi<nums.length)
        {
            ans[i++]=nums[lo++];
            ans[i++]=nums[hi++];
        }
        return ans;
    }
}