class Solution {
    int count=1;
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int max=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
               count=1;
                if(grid[i][j]==1)
                {
                area(grid,i,j);
                max=Math.max(max,count);
                }
            }
        }
        return max;
    }
    
    public int area(int[][] grid,int i,int j){
        if(i<0 || j<0 ||i>=grid.length || j>= grid[0].length)
        return 0;
        if(grid[i][j]==0)
            return 0;
        grid[i][j]=0;
        if(area(grid,i-1,j)==1)
             count++;
        if(area(grid,i+1,j)==1)
             count++;
        if(area(grid,i,j-1)==1)
             count++;
        if(area(grid,i,j+1)==1)
             count++;
        return 1;
    }
}