class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp=new int[triangle.size()];
        int s=triangle.size();
        for(int i=0;i<triangle.get(s-1).size();i++)
            dp[i]=triangle.get(s-1).get(i);
        for(int i=s-2;i>=0;i--)
        {
            for(int j=0;j<=i;j++)
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
        }
        return dp[0];
    }
}