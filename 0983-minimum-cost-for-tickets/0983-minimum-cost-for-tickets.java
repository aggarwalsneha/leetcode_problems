class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[]dp=new int[days.length+1];
        Arrays.fill(dp,-1);
        return solve(0,days,costs,dp);
    }
    
    int solve(int ind,int[]days,int[]costs,int[]dp)
    {
        if(ind>=days.length)
            return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        int option1=costs[0]+solve(ind+1,days,costs,dp);
        int i=0;
        for(i=ind;i<days.length && days[i]<days[ind]+7;i++);
        int option2=costs[1]+solve(i,days,costs,dp);
        for(i=ind;i<days.length && days[i]<days[ind]+30;i++);
        int option3=costs[2]+solve(i,days,costs,dp);
        
        return dp[ind]=Math.min(option1,Math.min(option2,option3));
    }
}