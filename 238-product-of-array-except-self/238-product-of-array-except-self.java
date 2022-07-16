class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=nums[0];
        int[] ans=new int[nums.length];
        ans[0]=1;
        for(int i=1;i<ans.length;i++)
        {
            ans[i]=prod;
            prod=prod*nums[i];
        }
        prod=1;
        for(int i=nums.length-1;i>=0;i--)
        {
            ans[i]=ans[i]*prod;
            prod=prod*nums[i];
        }
     return ans;   
    }
}