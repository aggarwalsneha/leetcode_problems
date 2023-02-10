class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0,zero=0,max=0;
        for(j=0;j<nums.length;j++)
        {
            if(nums[j]==0)
                zero++;
            if(zero>k){
                if(nums[i]==0)
                    zero--;
                i++;
            }
            if(zero<=k)
                max=Math.max(max,j-i+1);
        }
        return max;
    }
}