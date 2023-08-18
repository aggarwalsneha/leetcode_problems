class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connect=new boolean[n][n];
        int[] count=new int[n];
        for(int[] r:roads){
            count[r[0]]++;
            count[r[1]]++;
            connect[r[1]][r[0]]=true;
            connect[r[0]][r[1]]=true;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                ans=Math.max(ans,count[i]+count[j]-(connect[i][j] ? 1:0));
            }
        }
        return ans;
    }
}