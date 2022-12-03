class Solution {
    static class Pair{
        int first;
        int second;
        public Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    static int[] x={1,-1,0,0};
    static int[] y={0,0,1,-1};
    
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] ans=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    q.offer(new Pair(i,j));
                }else
                ans[i][j]=-1;
            }
        }
        while(!q.isEmpty())
        {
            Pair node=q.poll();
            int f=node.first;
            int s=node.second;
            for(int i=0;i<4;i++)
            {
                int r=f+x[i];
                int c=s+y[i];
                if(r>=m || c>=n || r<0 || c<0)
                    continue;
                if(ans[r][c]==-1)
                {
                    ans[r][c]=ans[f][s]+1;
                    q.offer(new Pair(r,c));
                }
            }
        }
        return ans;
    }
}