class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n=nums.length;
        long[] pre=new long[n];
        long[] succ=new long[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++)
            pre[i]=nums[i]+pre[i-1];
        // succ[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)
            succ[i]=succ[i+1]+nums[i+1];
        int ans=Integer.MAX_VALUE;
        int index=0;
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
           long la=pre[i]/(i+1);
            if(n-i-1!=0){
                long ra=succ[i]/(n-i-1);
                diff=(int)Math.abs(la-ra);
        }
            else
                diff=(int)la;
         
            if(diff<ans)
            {
                ans=diff;
                index=i;
            }
        }
        return index;
    }
}