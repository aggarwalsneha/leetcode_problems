class Solution {
    static int MOD=1000000007;
    public int ways(String[] pizza, int k) {
        int m=pizza.length;
        int n=pizza[0].length();
        int[][][] dp=new int[m][n][k];
        for(int[][]a:dp){
            for(int[]b:a)
                Arrays.fill(b,-1);
        }
        return solve(pizza,dp,0,0,k -1);
    }
    public int solve(String[] pizza,int[][][] dp,int row,int col,int k)
    {
        int m=pizza.length;
        int n=pizza[0].length();
        if(k==0)
            return 1;
        if(dp[row][col][k]!=-1)
            return dp[row][col][k];
        long ans=0;
        for(int i=row;i<m-1;i++) 
        {
            boolean upperHalfValid=isValid(pizza,row,i,col,n-1);
            boolean lowerHalfValid=isValid(pizza,i+1,m-1,col,n-1);
            if(upperHalfValid && lowerHalfValid)
            {
                int nextWays=(solve(pizza,dp,i+ 1,col,k-1));
                ans=(ans+nextWays)%MOD;
            }
        }
        for(int i=col;i<n-1;i++) 
        {
            boolean leftHalfValid=isValid(pizza,row,m-1,col,i);
            boolean rightHalfValid=isValid(pizza,row,m-1,i+1,n-1);
            if(leftHalfValid && rightHalfValid)
            {
                int nextWays=(solve(pizza,dp,row,i+1,k-1));
                ans=(ans+nextWays)%MOD;
            }
        }
        return dp[row][col][k]=(int)ans;
    }
    boolean isValid(String[] pizza,int startRow,int endRow,int startCol,int endCol)
    {
        for(int i=startRow;i<=endRow;i++)
        {
            for(int j=startCol;j<=endCol;j++)
            {
                if (pizza[i].charAt(j)=='A')
                    return true;
            }
        }
        return false;
    }
}