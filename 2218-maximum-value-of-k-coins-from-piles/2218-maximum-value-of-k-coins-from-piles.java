class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n=piles.size();
        int[][] dp=new int[n+1][k+1];
        for(int[]a:dp)
            Arrays.fill(a,-1);
        return solve(0,piles,k,dp);
    }
    
    public int solve(int ind,List<List<Integer>> piles,int k,int[][]dp){
        if(ind>=piles.size())
            return 0;
        if(dp[ind][k]!=-1)
            return dp[ind][k];
        int not_taken=solve(ind+1,piles,k,dp);
        int taken=0,sum=0;
        for(int i=0;i<Math.min(k,piles.get(ind).size());i++){
            sum+=piles.get(ind).get(i);
            taken=Math.max(taken,sum+solve(ind+1,piles,k-(i+1),dp));
        }
        return dp[ind][k]=Math.max(taken,not_taken);
    }
}