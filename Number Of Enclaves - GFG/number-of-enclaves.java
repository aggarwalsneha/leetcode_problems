//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int[] x=new int[]{0,0,1,-1};
    static int[] y=new int[]{1,-1,0,0};
    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<m;i++)
        {
            if(!visited[0][i] && grid[0][i]==1)
            dfs(0,i,grid,visited);
            if(!visited[n-1][i] && grid[n-1][i]==1)
            dfs(n-1,i,grid,visited);
        }
        for(int i=0;i<n;i++)
        {
            if(!visited[i][0] && grid[i][0]==1)
            dfs(i,0,grid,visited);
            if(!visited[i][m-1] && grid[i][m-1]==1)
            dfs(i,m-1,grid,visited);
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]==1)
                count++;
            }
        }
        return count;
    }
    
    public static void dfs(int r,int c,int[][]grid,boolean[][] visited)
    {
        visited[r][c]=true;
        for(int i=0;i<4;i++)
        {
            int new_r=r+x[i];
            int new_c=c+y[i];
            if(new_r>=0 && new_r<grid.length && new_c>=0 && new_c<grid[0].length 
            && !visited[new_r][new_c] && grid[new_r][new_c]==1){
                dfs(new_r,new_c,grid,visited);
            }
            
        }
    }
}