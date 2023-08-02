//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        Queue<Pair>q=new LinkedList<>();
        int[] x=new int[]{0,0,1,-1};
        int[] y=new int[]{1,-1,0,0};
        boolean[][] visited=new boolean[N][M];
        int steps=0;
        q.offer(new Pair(0,0));
        visited[0][0]=true;
        if(A[0][0]==0)
        return -1;
        while(!q.isEmpty()){
            steps++;
            int size=q.size();
            for(int j=0;j<size;j++){
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            if(r==X && c==Y)
            return steps-1;
            for(int i=0;i<4;i++){
                int new_r=r+x[i];
                int new_c=c+y[i];
                if(new_r>=0 && new_c>=0 && new_r<N && new_c<M && A[new_r][new_c]==1 && !visited[new_r][new_c]){
                    q.offer(new Pair(new_r,new_c));
                    visited[new_r][new_c]=true;
                }
            }
            }
        }
        return -1;
    }
};

class Pair{
    int row,col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}