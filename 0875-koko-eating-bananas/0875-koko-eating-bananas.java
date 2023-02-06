class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int val:piles)
            max=Math.max(max,val);
        int l=0,hi=max,ans=0;
        while(l<=hi)
        {
            int mid=(l+hi)/2;
            if(isPossible(piles,mid,h))
            {
                ans=mid;
                hi=mid-1;
            }
            else
                l=mid+1;
        }
        return ans;
    }
    public boolean isPossible(int[] piles,int sp,int h)
    {
        int time=0;
        for(int i=0;i<piles.length;i++)
        {
            time+=(int)Math.ceil(piles[i]*1.0/sp);
        }
        return time<=h;
    }
}