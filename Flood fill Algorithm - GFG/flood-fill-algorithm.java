//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int initial=image[sr][sc];
        if(initial!=newColor)
        dfs(sr,sc,image,newColor,initial);
        return image;
    }
    
    public void dfs(int sr,int sc,int[][]image,int newC,int initC)
    {
        if(image[sr][sc]==initC)
        {
            image[sr][sc]=newC;
            if(sr>0)
            dfs(sr-1,sc,image,newC,initC);
            if(sr<image.length-1)
            dfs(sr+1,sc,image,newC,initC);
            if(sc>0)
            dfs(sr,sc-1,image,newC,initC);
            if(sc<image[0].length-1)
            dfs(sr,sc+1,image,newC,initC);
        }
    }
}