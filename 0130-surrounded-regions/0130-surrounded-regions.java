class Solution {
    int[] x=new int[]{0,0,1,-1};
    int[] y=new int[]{1,-1,0,0};
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<n;i++)
        {
            if(!visited[0][i] && board[0][i]=='O')
                dfs(0,i,board,visited);
            if(!visited[m-1][i] && board[m-1][i]=='O')
                dfs(m-1,i,board,visited);
        }
        for(int i=0;i<m;i++)
        {
            if(!visited[i][0] && board[i][0]=='O')
                dfs(i,0,board,visited);
            if(!visited[i][n-1] && board[i][n-1]=='O')
                dfs(i,n-1,board,visited);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!visited[i][j] && board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
    
    public void dfs(int i,int j,char[][] board,boolean[][] visited)
    {
        visited[i][j]=true;
        for(int k=0;k<4;k++)
        {
            int new_r=i+x[k];
            int new_c=j+y[k];
            if(new_r>=0 && new_r<board.length && new_c>=0 && new_c<board[0].length && board[new_r][new_c]=='O' && !visited[new_r][new_c])
                dfs(new_r,new_c,board,visited);
        }
    }
}