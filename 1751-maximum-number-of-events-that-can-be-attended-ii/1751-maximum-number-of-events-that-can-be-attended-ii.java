class Solution {
    public int maxValue(int[][] events, int k) {
        int n=events.length;
        Arrays.sort(events,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int[][] dp=new int[n][k+1];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        return solve(events,dp,n,k,0,0);
    }
    
    int solve(int[][] events,int[][] dp,int n,int k,int ind,int end){
        if(ind>=n || k==0)
            return 0;
        if(events[ind][0]<=end)
            return solve(events,dp,n,k,ind+1,end);
        if(dp[ind][k]!=-1)
            return dp[ind][k];
        return dp[ind][k]=Math.max(solve(events,dp,n,k,ind+1,end),
                                   events[ind][2]+solve(events,dp,n,k-1,ind+1,events[ind][1]));
    }
}