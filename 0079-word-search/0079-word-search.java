class Solution {
    int[] x=new int[]{0,0,1,-1};
    int[] y=new int[]{1,-1,0,0};
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dfs(board,i,j,0,word,n,m))
                    return true;
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board,int r,int c,int ind,String word,int n,int m){
        if(ind==word.length())
            return true;
        if(r>=n || r<0 || c>=m || c<0)
            return false;
        if(word.charAt(ind)!=board[r][c])
            return false;
        for(int i=0;i<4;i++){
            char ch=board[r][c];
            board[r][c]='#';
            int new_r=r+x[i];
            int new_c=c+y[i];
            if(dfs(board,new_r,new_c,ind+1,word,n,m)){
                board[r][c]=ch;
                return true;
            }
            board[r][c]=ch;
        }
        return false;
    }
}

