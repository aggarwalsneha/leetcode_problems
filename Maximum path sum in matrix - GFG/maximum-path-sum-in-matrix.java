//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int matrix[][])
    {
        if(N==1)
        return matrix[0][0];
        int max=Integer.MIN_VALUE;
        for(int i=1;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(j==0)
                matrix[i][j]+=Math.max(matrix[i-1][j],matrix[i-1][j+1]);
                else if(j==N-1)
                matrix[i][j]+=Math.max(matrix[i-1][j],matrix[i-1][j-1]);
                else
                matrix[i][j]+=Math.max(matrix[i-1][j-1],Math.max(matrix[i-1][j],matrix[i-1][j+1]));
                if(i==N-1)
                max=Math.max(max,matrix[i][j]);
            }
        }
        return max;
        // code here
    }
}