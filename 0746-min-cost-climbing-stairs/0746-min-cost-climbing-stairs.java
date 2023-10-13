class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev=0,prev2=0;
        for(int i=2;i<=cost.length;i++)
        {
            int f=prev+cost[i-1];
            int s=prev2+cost[i-2];
            int curr=Math.min(f,s);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}