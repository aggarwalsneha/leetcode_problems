//{ Driver Code Starts
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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int[]x=new int[]{0,0,1,-1};
    static int[]y=new int[]{1,-1,0,0};
    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        Queue<Pair>q=new LinkedList<>();
        for(int[] arr:dist)
        Arrays.fill(arr,Integer.MAX_VALUE);
        dist[source[0]][source[1]]=0;
        q.offer(new Pair(0,source[0],source[1]));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int d=curr.dist;
            for(int i=0;i<4;i++)
            {
                int new_r=r+x[i];
                int new_c=c+y[i];
                if(new_r>=0 && new_r<n && new_c>=0 && new_c<m && grid[new_r][new_c]==1){
                    if(d+1<dist[new_r][new_c]){
                        dist[new_r][new_c]=d+1;
                        q.offer(new Pair(d+1,new_r,new_c));
                    }
                }
                
            }
        }
        return dist[destination[0]][destination[1]]==Integer.MAX_VALUE?-1:dist[destination[0]][destination[1]];
    }
}

class Pair{
    int dist,row,col;
    Pair(int dist,int row,int col){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
