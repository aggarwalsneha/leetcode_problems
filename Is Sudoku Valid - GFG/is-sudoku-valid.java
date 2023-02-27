//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int N=9;
    static int isValid(int mat[][]){
        // code here
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(mat[i][j]!=0){
                    int val=mat[i][j];
                    mat[i][j]=0;
                    if(unique(mat,i,j,val))
                    mat[i][j]=val;
                    else
                    return 0;
                }
            }
        }
        return 1;
    }
    static boolean unique(int mat[][],int r,int c,int val){
        for(int i=0;i<9;i++){
            if(mat[i][c]==val)
            return false;
            else if(mat[r][i]==val)
            return false;
            else if(mat[3*(r/3)+i/3][3*(c/3)+(i%3)]==val)
            return false;
        }
        return true;
    }
}