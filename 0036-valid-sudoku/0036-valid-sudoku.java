class Solution {
    int N=9;
    public boolean isValidSudoku(char[][] board) {
        boolean[] unique = new boolean[N+1];
        for(int i=0;i<N;i++){
            Arrays.fill(unique,false);
            for(int j=0;j<N;j++){
                if(board[i][j]=='.')
                continue;
                char Z=board[i][j];
                if(unique[Z-'0'])
                return false;
                unique[Z-'0']=true;
            }
        }
        for(int i=0;i<N;i++){
            Arrays.fill(unique,false);
            for(int j=0;j<N;j++){
                if(board[j][i]=='.')
                continue;
                char Z=board[j][i];
                if(unique[Z-'0'])
                return false;
                unique[Z-'0']=true;
            }
        }
        for(int i=0;i<N-2;i+=3){
            for(int j=0;j<N-2;j+=3){
                Arrays.fill(unique, false);
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        int X=i+k;
                        int Y=j+l;
                        if(board[X][Y]=='.')
                        continue;
                        char Z=board[X][Y];
                        if (unique[Z-'0'])
                        return false;
                        unique[Z-'0']=true;
                    }
                }
            }
        }
        return true;
    }
}