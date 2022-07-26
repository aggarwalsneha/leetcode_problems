class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initc=image[sr][sc];
        if(initc!=color)
            dfs(image,sr,sc,initc,color);
        return image;
        
    }
    public void dfs(int[][] image,int r,int c,int initc,int color)
    {
        if(image[r][c]==initc)
        {
            image[r][c]=color;
            if(r>=1)
                dfs(image,r-1,c,initc,color);
            if(c>=1)
                dfs(image,r,c-1,initc,color);
            if(r+1<image.length)
                dfs(image,r+1,c,initc,color);
            if(c+1<image[0].length)
                dfs(image,r,c+1,initc,color);
        }
    }
}