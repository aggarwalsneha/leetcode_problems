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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
        if(n==0)
            return "-1";
        if(n==1)
            return arr[0]; 
        Arrays.sort(arr);
        String str="";
        int l=Math.min(arr[0].length(),arr[n-1].length());
        int i=0;
        while(i<l && arr[0].charAt(i)==arr[n-1].charAt(i)){
            str+=arr[0].charAt(i);
            i++;
        }
        if(str.length()==0)
            return "-1";
        else
            return str;
    }
}