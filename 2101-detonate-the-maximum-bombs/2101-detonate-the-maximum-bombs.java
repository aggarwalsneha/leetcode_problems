class Solution {
    public int maximumDetonation(int[][] bombs) {
        int ans=0;
        for(int i=0;i<bombs.length;i++){
            ans=Math.max(ans,dfs(i,bombs,new boolean[bombs.length]));
        }
        return ans;
    }
    public int dfs(int i,int[][] bombs,boolean[] visited){
        int count=1;
        visited[i]=true;
        for(int j=0;j<bombs.length;j++){
            if(!visited[j] && inRange(bombs[i],bombs[j]))
                count+=dfs(j,bombs,visited);
        }
        return count;
    }
    public boolean inRange(int[] bombA,int[] bombB){
        long x=bombA[0]-bombB[0];
        long y=bombA[1]-bombB[1];
        long r=bombA[2];
        return x*x+y*y<=r*r;
    }
}