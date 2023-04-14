class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isSafe(board,i,j,k)){
                            board[i][j]=k;
                            if(solve(board))
                                return true;
                            else
                                board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isSafe(char[][] board,int r,int c,char k){
        for(int i=0;i<9;i++){
            if(board[i][c]==k)
                return false;
            if(board[r][i]==k)
                return false;
            if(board[3*(r/3)+(i/3)][3*(c/3)+(i%3)]==k)
                return false;
        }
        return true;
    }
}