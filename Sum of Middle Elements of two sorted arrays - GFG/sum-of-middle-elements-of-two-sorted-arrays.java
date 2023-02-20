//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar1 = new int[n], ar2 = new int[n];
            String[] inputLine = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                ar1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                ar2[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().findMidSum(ar1, ar2, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMidSum(int[] ar1, int[] ar2, int n) {
        // code here
       int i=0,j=0;
       int count=0,m1=0,m2=0;
       while(i<n && j<n)
       {
           if(ar1[i]<=ar2[j]){
           i++;
           count++;
           if(count==n)
           {
               m1=ar1[i-1];
           }
           else if(count==n+1)
           {
               m2=ar1[i-1];
               break;
           }
           }
           else{
               j++;
               count++;
               if(count==n)
               {
                   m1=ar2[j-1];
               }
               else if(count==n+1)
               {
                   m2=ar2[j-1];
                   break;
               }
           }
       }
       while(i<n)
       {
           i++;
           count++;
           
           if(count==n)
           {
               m1=ar1[i-1];
           }
           else if(count==n+1)
           {
               m2=ar1[i-1];
           }
       }
       while(j<n)
       {
           j++;
           count++;
           if(count==n)
           {
               m1=ar2[j-1];
           }
           else if(count==n+1)
           {
               m2=ar2[j-1];
           }
       }
       return (m1+m2);
    }
}