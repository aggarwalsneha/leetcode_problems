class Solution {
    public int shortestBridge(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int[][] dirs=new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};
        Queue<int[]> q=new LinkedList<>();
        boolean found=false;
        for(int i=0;i<m;i++){
            if(found){
                break;
            }
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,visited,q,i,j,dirs);
                    found=true;
                    break;
                }
            }
        }
        int step=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] curr=q.poll();
                for(int[] d:dirs) {
                    int i=curr[0]+d[0];
                    int j=curr[1]+d[1];
                    if(i>=0 && j>=0 && i<m && j<n && !visited[i][j]){
                        if(grid[i][j]==1){
                            return step;
                        }
                        q.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
    void dfs(int[][] grid,boolean[][] visited,Queue<int[]> q,int i,int j,int[][] dirs){
        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length || visited[i][j] || grid[i][j]==0){
            return;
        }
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        for(int[] d:dirs) {
            dfs(grid,visited,q,i+d[0],j+d[1],dirs);
        }
    }
}