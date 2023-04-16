class Solution {
    int mod=1000000007;
    public int numWays(String[] words, String target) {
        int k=words[0].length();
        int m=target.length();
        int[][] freq=new int[26][k];
        for(int i=0;i<k;i++){
            for(String word:words){
                char ch=word.charAt(i);
                freq[ch-'a'][i]++;
            }
        }
        long[][] dp=new long[m+1][k+1];
        for(long[]a:dp)
            Arrays.fill(a,-1);
        return (int)solve(0,0,freq,target,dp);
    }
    
    public long solve(int i,int j,int[][] freq,String target,long[][] dp){
        if(i==target.length())
            return 1;
        if(j>=freq[0].length)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        long not_taken=solve(i,j+1,freq,target,dp)%mod;
        long taken=(freq[target.charAt(i)-'a'][j]*solve(i+1,j+1,freq,target,dp))%mod;
        
        return dp[i][j]=(not_taken+taken)%mod;
    }
}