class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(char[] row:board)
            Arrays.fill(row,'.');
        solve(0,n,board);
        return ans;
    }
    
    void solve(int x,int n,char[][]board)
    {
        if(x==n)
        {
            List<String>temp=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                String str="";
                for(int j=0;j<n;j++)
                {
                    str+=board[i][j];
                }
                temp.add(str);
            }
            ans.add(temp);
        }
        for(int col=0;col<n;col++)
        {
            if(isSafe(x,col,board,n))
            {
                board[x][col]='Q';
                solve(x+1,n,board);
                board[x][col]='.';
            }
        }
    }
    boolean isSafe(int x,int y,char[][]board,int n)
    {
        for(int i=0;i<x;i++)
        {
            if(board[i][y]=='Q')
                return false;
        }
        int row=x;
        int col=y;
        while(row>=0 && col>=0)
        {
            if(board[row][col]=='Q')
                return false;
            row--;col--;
        }
        row=x;col=y;
        while(row>=0 && col<n)
        {
            if(board[row][col]=='Q')
                return false;
            row--;col++;
        }
        return true;
    }
    
}                                                                                                                                 