class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        dp=new int[word1.length()+1][word2.length()+1];
        for(int[]r:dp)
            Arrays.fill(r,-1);
        return solve(word1,word2,word1.length(),word2.length());
    }

    int solve(String word1,String word2,int n1, int n2) {
        if(n1==0){
            return n2;
        }
        if(n2==0){
            return n1;
        }
        if(dp[n1][n2]!=-1)
            return dp[n1][n2];
        int min=0;
        if(word1.charAt(n1-1)==word2.charAt(n2-1)){
            min=solve(word1,word2,n1-1,n2-1);
        }
        else{
            int insert=solve(word1,word2,n1,n2-1);
            int delete=solve(word1,word2,n1-1,n2);
            int replace=solve(word1,word2,n1-1,n2-1);
            min=1+Math.min(insert,Math.min(delete,replace));
        }
        dp[n1][n2]=min;
        return min;
    }
}