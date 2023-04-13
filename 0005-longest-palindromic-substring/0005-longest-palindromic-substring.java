class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1)
            return s;
        int[][] dp=new int[n][n];
        int start=0,end=0;
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(i==j)
                dp[i][j]=1;
                else if(i-j==1 && s.charAt(i)==s.charAt(j))
                dp[i][j]=1;
                else if(s.charAt(i)==s.charAt(j) && dp[i-1][j+1]==1)
                dp[i][j]=1;
                if(dp[i][j]==1 && i-j>end-start){
                    start=j;
                    end=i;
                }
            }
        }
        return s.substring(start,end+1);
    }
}