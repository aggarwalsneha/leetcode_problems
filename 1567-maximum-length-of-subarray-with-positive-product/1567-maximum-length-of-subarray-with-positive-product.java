class Solution {
    public int getMaxLen(int[] nums) {
        int maxLen=0,count=0,zero=-1,firstNeg=-1;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<0){
                count++;
                if(firstNeg==-1)
                firstNeg=i;
            }
            if(nums[i]==0){
                firstNeg=-1;
                count=0;
                zero=i;
            }
            else{
                if(count%2==0){
                    maxLen=Math.max(maxLen,i-zero);
                }
                else{
                    maxLen=Math.max(maxLen,i-firstNeg);
                }
            }
        }
        return maxLen;   
    }
}