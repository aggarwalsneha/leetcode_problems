class Solution {
    int[][] dp;
    int[][] dir={{0, 1},{0, -1},{1, 0},{-1, 0}};
    int mod = 1_000_000_007;
    
    public int countPaths(int[][] grid){
        int m=grid.length,n=grid[0].length;
        dp=new int[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=(ans+dfs(grid,i,j))%mod;
            }
        }
        return ans;
    }
    
    int dfs(int[][] grid, int i, int j){
        if (dp[i][j]!=0)
            return dp[i][j];
        int ans=1;
        for (int[] d:dir){
            int r=i+d[0],c=j+d[1];
            if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]<grid[i][j]){
                ans+=dfs(grid,r,c);
                ans%=mod;
            }
        }
        return dp[i][j]=ans;
    }
}