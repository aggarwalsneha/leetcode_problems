class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=0;i<=s.length();i++){
            for(String str:wordDict){
                int len=str.length();
                if(len<=i){
                    if(dp[i-len] && s.substring(i-len,i).equals(str)){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}