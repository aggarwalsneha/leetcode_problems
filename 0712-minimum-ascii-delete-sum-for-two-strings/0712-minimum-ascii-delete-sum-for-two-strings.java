class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    int sum=0;
                    for(int k=1;k<=Math.max(j,i);k++){
                        sum+=(i==0?s2.charAt(k-1):s1.charAt(k-1));
                    }
                    dp[i][j]=sum;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else{
                    dp[i][j]=Math.min(s1.charAt(i-1)+dp[i-1][j],s2.charAt(j-1)+dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}