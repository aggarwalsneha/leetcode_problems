//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String s){
        // code here
        int n=s.length();
        if(n==1)
            return s;
        int[][] dp=new int[n][n];
        int start=0,end=0;
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(i==j)
                dp[i][j]=1;
                else if(i-j==1 && s.charAt(i)==s.charAt(j))
                dp[i][j]=1;
                else if(s.charAt(i)==s.charAt(j) && dp[i-1][j+1]==1)
                dp[i][j]=1;
                if(dp[i][j]==1 && i-j>end-start){
                    start=j;
                    end=i;
                }
            }
        }
        return s.substring(start,end+1);
    }
}