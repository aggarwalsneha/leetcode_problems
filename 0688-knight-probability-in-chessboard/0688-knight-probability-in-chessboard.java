class Solution {
    int[][]dir=new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    double[][][] dp;
    public double knightProbability(int n, int k, int row, int column) {
        dp=new double[n][n][k+1];
        return solve(n,k,row,column);
    }
    
    public double solve(int n,int k,int r,int c){
        if(r<0 || c<0 || r>=n || c>=n)
            return 0;
        if(k==0)
            return 1;
        if(dp[r][c][k]!=0)
            return dp[r][c][k];
        double p=0;
        for(int i=0;i<dir.length;i++){
            p+=0.125*solve(n,k-1,r+dir[i][0],c+dir[i][1]);
        }
        return dp[r][c][k]=p;
    }
}