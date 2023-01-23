//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] dp=new int[N][sum+1];
        for(int[] a:dp)
        Arrays.fill(a,-1);
        return solve(N-1,arr,sum,dp);
    }
    
    static boolean solve(int ind,int[]arr,int sum,int[][]dp)
    {
        if(sum==0)
        return true;
        if(ind==0)
        return arr[ind]==sum;
        if(dp[ind][sum]!=-1)
        return dp[ind][sum]==0? false:true;
        boolean not_pick=solve(ind-1,arr,sum,dp);
        boolean pick=false;
        if(arr[ind]<=sum)
        pick=solve(ind-1,arr,sum-arr[ind],dp);
        boolean result=pick || not_pick;
        dp[ind][sum]=result?1:0;
        return result;
    }
}