//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    static long fibSum(long n){
        //code here
        if(n==0)
        return 0;
        if(n==1)
        return 1;
        long f1=0;
        long f2=1;
        long f3=f1+f2;
        long sum=f3;
        for(int i=2;i<=n;i++)
        {
            sum+=f3;
            f1=f2;
            f2=f3;
            f3=(f1+f2)%1000000007;
        }
        return sum%1000000007;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            long N = Long.parseLong(read.readLine());
           
            Solution ob = new Solution();
            System.out.println(ob.fibSum(N));
        }
    }
}
// } Driver Code Ends