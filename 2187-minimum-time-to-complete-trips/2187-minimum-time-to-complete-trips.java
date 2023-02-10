class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low=Integer.MAX_VALUE;
        for(int i=0;i<time.length;i++)
            low=Math.min(low,time[i]);
        long high=low*totalTrips;
        long ans=high;
        while(low<=high)
        {
            long mid=(low+high)/2;
            long num=func(time,mid);
            if(num>=totalTrips){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
    
    public long func(int[]arr,long t)
    {
        long count=0;
        for(int i=0;i<arr.length;i++)
            count+=t/arr[i];
        return count;
    }
}