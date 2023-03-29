class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n=satisfaction.length;
        int[]curr=new int[n+1];
        int[]next=new int[n+1];
        for(int ind=n-1;ind>=0;ind--)
        {
            for(int time=0;time<n;time++)
            {
                int pick=satisfaction[ind]*(time+1)+next[time+1];
                int nonpick=next[time];
                curr[time]=Math.max(pick,nonpick);
            }
            next=curr;
        }
        return next[0];
    }
}