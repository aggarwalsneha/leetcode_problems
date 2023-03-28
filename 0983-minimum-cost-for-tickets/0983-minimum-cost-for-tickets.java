class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[]dp=new int[days.length+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[days.length]=0;
        for(int i=days.length-1;i>=0;i--)
        {
            int option1=costs[0]+dp[i+1];
            int j;
            for(j=i;j<days.length && days[j]<days[i]+7;j++);
            int option2=costs[1]+dp[j];
            for(j=i;j<days.length && days[j]<days[i]+30;j++);
            int option3=costs[2]+dp[j];
            
            dp[i]=Math.min(option1,Math.min(option2,option3));
            
        }
        return dp[0];
    }
}