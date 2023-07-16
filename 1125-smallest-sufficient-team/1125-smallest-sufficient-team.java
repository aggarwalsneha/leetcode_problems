class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n=people.size(),m=req_skills.length;
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<m;i++)
            hm.put(req_skills[i],i);
        int[] skillMask=new int[n];
        for(int i=0;i<n;i++){
            for(String s:people.get(i))
                skillMask[i] |=1<<hm.get(s);
        }
        long[] dp=new long[1<<m];
        Arrays.fill(dp,-1);
        long ansMask=solve(skillMask,dp,n,(1<<m)-1);
        int[] ans=new int[Long.bitCount(ansMask)];
        int ptr=0;
        for(int i=0;i<n;i++){
            if(((ansMask>>i)&1)==1)
                ans[ptr++]=i;
        }
        return ans;
    }
    
    Long solve(int[] skillMask,long[] dp,int n,int mask){
        if(mask==0)
            return 0L;
        if(dp[mask]!=-1)
            return dp[mask];
        for(int i=0;i<n;i++){
            int smaller=mask & ~skillMask[i];
            if(smaller!=mask){
                long peopleMask=solve(skillMask,dp,n,smaller) | (1L<<i);
                if(dp[mask]==-1 || Long.bitCount(peopleMask)<Long.bitCount(dp[mask]))
                    dp[mask]=peopleMask;
            }
        }
        return dp[mask];
    }
}

