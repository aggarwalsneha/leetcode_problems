class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m=img.length;
        int n=img[0].length;
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j]=solve(img,i,j);
            }
        }
        return res;
    }
    public int solve(int[][] img,int x,int y){
        int m=img.length;
        int n=img[0].length;
        int sum=0;
        int count=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(x+i<0 || x+i>=m || y+j<0 || y+j>=n){
                    continue;
                }
                count++;
                sum+=img[x+i][y+j];
            }
        }
        return sum/ count;
    }
}