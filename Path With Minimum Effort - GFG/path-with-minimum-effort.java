//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int[] x=new int[]{0,0,1,-1};
    static int[] y=new int[]{1,-1,0,0};
    int MinimumEffort(int heights[][]) {
        Queue<Pair>q=new PriorityQueue<>((a,b)->a.dist-b.dist);
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int[] a:dist)
        Arrays.fill(a,Integer.MAX_VALUE);
        dist[0][0]=0;
        q.offer(new Pair(0,0,0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int d=curr.dist;
            for(int i=0;i<4;i++){
                int new_r=r+x[i];
                int new_c=c+y[i];
                if(new_r>=0 && new_r<n && new_c>=0 && new_c<m){
                    int diff=Math.max(d,Math.abs(heights[new_r][new_c]-heights[r][c]));
                    if(diff<dist[new_r][new_c]){
                        dist[new_r][new_c]=diff;
                        q.offer(new Pair(diff,new_r,new_c));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}

class Pair{
    int dist,row,col;
    Pair(int dist,int row,int col){
        this.dist=dist;
        this.row=row;
        this.col=col;
    }
}