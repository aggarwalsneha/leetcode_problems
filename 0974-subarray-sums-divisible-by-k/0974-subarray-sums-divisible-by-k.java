class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            nums[i]=sum;
        }
        int count=0;
        int[] freq=new int[k];
        freq[0]=1;
        for(int i=0;i<nums.length;i++)
        {
            int rem=nums[i]%k;
            if(rem<0)
                rem+=k;
            count+=freq[rem];
            freq[rem]++;
        }
        return count;
    }
}