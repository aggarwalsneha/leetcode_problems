class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length,max_len=0,res=0;
        int[] length=new int[n];
        int[] count=new int[n];
        Arrays.fill(length,1);
        Arrays.fill(count,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(length[j]+1>length[i]){
                        length[i]=length[j]+1;
                        count[i]=0;
                    }
                    if(length[j]+1==length[i])
                        count[i]+=count[j];
                }
            }
        }
        for(int l:length)
            max_len=Math.max(max_len,l);
        for(int i=0;i<n;i++){
            if(length[i]==max_len)
                res+=count[i];
        }
        return res;
    }
}