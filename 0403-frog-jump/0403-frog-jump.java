class Solution {
    
    HashMap<Integer,Integer>hm=new HashMap<>();
    int dp[][]=new int[2001][2001];
    
    public boolean canCross(int[] stones) {
        for(int i=0;i<stones.length;i++)
            hm.put(stones[i],i);
        for(int[] a:dp)
            Arrays.fill(a,-1);
        return solve(stones,stones.length,0,0);
    }
    
    boolean solve(int[] stones,int n,int ind,int prev){
        if(ind==n-1)
            return true;
        if(dp[ind][prev]!=-1)
            return dp[ind][prev]==1;
        boolean ans=false;
        for(int i=prev-1;i<=prev+1;i++){
            if(i>0 && hm.containsKey(stones[ind]+i))
                ans=ans||solve(stones,n,hm.get(stones[ind]+i),i);
        }
        dp[ind][prev]=ans?1:0;
        return ans;
    }
}