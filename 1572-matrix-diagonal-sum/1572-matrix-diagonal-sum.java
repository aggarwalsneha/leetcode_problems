class Solution {
    public int diagonalSum(int[][] mat) {
      int sum=0;int k=mat.length-1;
        for(int i=0,j=0;i<mat.length;i++,j++)
        {
                if(i==j)
                sum=sum+mat[i][j];
            sum=sum+mat[i][k--];
        }
        if(mat.length%2!=0&&mat.length!=1)
            sum=sum-mat[mat.length/2][mat.length/2];
        if(mat.length!=1)
        return sum;
        else
            return mat[0][0];
    }
}