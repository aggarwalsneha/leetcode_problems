class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        if(obstacleGrid[m-1][n-1]==1)
        return 0;
        for(int[] row:dp)
        Arrays.fill(row,-1);
        return count(0,0,m,n,dp,obstacleGrid);
    }

    public int count(int i,int j,int m,int n,int[][] dp,int[][] grid)
    {
        if(i==(m-1) && j==(n-1))
        return 1;
        if(i>=m || j>=n || grid[i][j]==1)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        return dp[i][j]=count(i+1,j,m,n,dp,grid)+count(i,j+1,m,n,dp,grid);
    }
}