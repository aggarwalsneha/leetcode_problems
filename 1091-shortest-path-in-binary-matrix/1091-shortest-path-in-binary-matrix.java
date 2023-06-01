class Solution {
    int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{1,1},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1)
            return -1;
        boolean[][] visited=new boolean[m][n];
        visited[0][0]=true;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{0,0});
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] pop=q.poll();
                if(pop[0]==m-1 && pop[1]==n-1)
                    return ans+1;
                for(int j=0;j<8;j++){
                    int r=pop[0]+dir[j][0];
                    int c=pop[1]+dir[j][1];
                    
                    if(r>=0 && c>=0 && r<m && c<n && !visited[r][c] && grid[r][c]!=1){
                        q.add(new int[]{r,c});
                        visited[r][c]=true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}