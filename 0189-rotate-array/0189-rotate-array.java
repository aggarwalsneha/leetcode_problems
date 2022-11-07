class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int[] ans=new int[nums.length];
        int start=nums.length-k;
        int j=0;
        for(int i=start;i<nums.length;i++)
        {
            ans[j++]=nums[i];
        }
        for(int i=0;i<start;i++)
        {
            ans[j++]=nums[i];
        }
        for(int i=0;i<nums.length;i++)
            nums[i]=ans[i];
    }
}