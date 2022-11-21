class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
     int r=maze.length,c=maze[0].length;
    int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int sr=entrance[0],sc=entrance[1];
        maze[sr][sc]='+';
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{sr,sc,0});
        while(!q.isEmpty())
        {
            int[] curr=q.poll();
            int cr=curr[0],cc=curr[1],cd=curr[2];
            for(int[] d:dir)
            {
                int nr=cr+d[0],nc=cc+d[1];
                if(nr>=0 && nr<r && nc>=0 && nc<c && maze[nr][nc]=='.')
                {
                    if(nr==0 || nr==r-1 || nc==0 || nc==c-1)
                        return cd+1;
                    maze[nr][nc]='+';
                    q.offer(new int[]{nr,nc,cd+1});
                }
            }
        }
        return -1;
    }
}