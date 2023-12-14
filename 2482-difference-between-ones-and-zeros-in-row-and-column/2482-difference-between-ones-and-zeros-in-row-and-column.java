class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] row=new int[m][2];
        int[][] col=new int[n][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    row[i][0]++;
                    col[j][0]++;
                }
                else{
                    row[i][1]++;
                    col[j][1]++;
                }
            }
        }
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=row[i][1]+col[j][1]-row[i][0]-col[j][0];
            }
        }
        return ans;
    }
}