//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().countPairsWithDiffK(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    int countPairsWithDiffK(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int count=0;
        // int low=0,high=1;
        for(int i=0;i<n;i++)
        {
            int x=bs(arr,arr[i]+k,i+1,n);
            if(x!=n){
            int y=bs(arr,arr[i]+k+1,i+1,n);
            count+=y-x;
            }
        }
        return count;
        
    }
    
    static int bs(int[]arr,int t,int l,int h)
    {
        int ans=h;
        h=arr.length-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(arr[mid]>=t)
            {
                ans=mid;
                h=mid-1;
            }
            else
            l=mid+1;
        }
        return ans;
    }
}