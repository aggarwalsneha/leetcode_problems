class Solution {
    double[][] dp=new double[200][200];
    public double soupServings(int n) {
        if(n>4800)
            return 1.0;
        int m=(n+24)/25;
        return solve(m,m);
    }
    public double solve(int a,int b) {
        if(a<=0 && b<=0)
            return 0.5;
        if(a<=0)
            return 1;
        if(b<=0)
            return 0;
        if(dp[a][b]>0)
            return dp[a][b];
        return dp[a][b]=0.25*(solve(a-4,b)+solve(a-3,b-1)+solve(a-2,b-2)+solve(a-1,b-3));
    }
}