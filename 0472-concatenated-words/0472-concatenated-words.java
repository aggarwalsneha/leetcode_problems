class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> w=new HashSet<>(Arrays.asList(words));
        List<String>ans=new ArrayList<>();
        for(String word:words)
        {
            int n=word.length();
            boolean[] dp=new boolean[n+1];
            dp[0]=true;
            for(int i=1;i<=n;i++)
            {
                for(int j=(i==n?1:0);!dp[i]&&j<i;j++)
                    dp[i]=dp[j]&& w.contains(word.substring(j,i));
            }
            if(dp[n])
                ans.add(word);
        }
        return ans;
    }
}